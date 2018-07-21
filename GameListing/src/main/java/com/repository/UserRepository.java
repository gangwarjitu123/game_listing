package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByUserNameAndUserPassword(String userName,String userPassword);
}
