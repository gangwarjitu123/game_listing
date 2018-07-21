package com.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Game;

public interface GameRepository  extends JpaRepository<Game, Integer>{
	
	public List<Game> findByPlatformContaining(String platForm);

}
