package com.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CustomGameException;
import com.response.Response;
import com.service.GameService;

@RestController
public class GameController {
	@Autowired
	GameService gameService;

	@GetMapping("/getGames")
	public ResponseEntity<Response> getGames(@RequestParam(value = "type") String type,
			@RequestHeader(value = "token", required = false) String token) {
		if (token == null) {
			throw new CustomGameException("token is missing as part of header ", HttpStatus.BAD_REQUEST);
		}
		Response response = gameService.getGamesList(type, token);

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
