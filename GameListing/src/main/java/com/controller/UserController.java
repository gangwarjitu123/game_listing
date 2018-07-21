package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.User;
import com.response.Response;
import com.service.UserService;

@RestController
@RequestMapping("/v0.1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/gettoken")
	public ResponseEntity<Response> getToken(@Valid @RequestBody User user)
	{
		Response response=userService.geToken(user);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}

}
