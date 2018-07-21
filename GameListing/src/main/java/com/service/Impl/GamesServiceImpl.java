package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Enum.Type;
import com.exception.CustomGameException;
import com.jwt.JwtGenerateAndParseToken;
import com.models.Game;
import com.repository.GameRepository;
import com.response.Response;
import com.service.GameService;

@Service
public class GamesServiceImpl implements GameService {
	@Autowired
	JwtGenerateAndParseToken jwtGenerateAndParseToken;
	@Autowired
	GameRepository gameRepository;
	/**
	 * type ==all then then fetch all  games from database and other type will contains the value of platform form bases on you want 
	 * to apply search in database 
	 */

	@Override
	public Response getGamesList(String type, String token) {
		boolean flag = jwtGenerateAndParseToken.parseJwtToken(token);
		List<Game> list = null;
		if (!flag) {
			throw new CustomGameException("invalid header token", HttpStatus.BAD_REQUEST);
		}
		if (type.equalsIgnoreCase(Type.All.toString()) || type==null) {
			list = gameRepository.findAll();
		}else{
			list=gameRepository.findByPlatformContaining(type);
		}
	

		Response<List<Game>> listOfGames = new Response<List<Game>>();
		listOfGames.setMessage("success");
		listOfGames.setStatus("200");
		listOfGames.setData(list);
		return listOfGames;
	}

}
