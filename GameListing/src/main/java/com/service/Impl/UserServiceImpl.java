package com.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exception.CustomGameException;
import com.jwt.JwtGenerateAndParseToken;
import com.jwt.JwtToken;
import com.models.User;
import com.repository.UserRepository;
import com.response.Response;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService
{   @Autowired
	private UserRepository userRepository;
   @Autowired
   JwtGenerateAndParseToken jwtGenerateAndParseToken;

	@Override
	public Response<String> geToken(User user) {
		Optional<User> optionalUser=userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		User dbUser=optionalUser.orElseThrow(()->  new CustomGameException("username or password is  incorrect",HttpStatus.BAD_REQUEST));
		Response<String> response = new Response<String>();
		response.setMessage("token get successfully");
		response.setStatus("200");
		JwtToken jwtToken = new JwtToken();
		jwtToken.setIssuer(dbUser.getName());
		jwtToken.setUserId(dbUser.getUserId());
		
		response.setData(jwtGenerateAndParseToken.generateToken(jwtToken));
		return response;
	}

}
