package com.service;

import org.springframework.stereotype.Service;

import com.models.User;
import com.response.Response;
@Service
public interface UserService {

	public Response geToken(User user);

}
