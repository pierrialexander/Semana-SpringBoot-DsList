package com.devspring.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devspring.dslist.dto.GameListDTO;
import com.devspring.dslist.entities.GameList;
import com.devspring.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		
		// Transforma uma lista de Game em uma GameMinDTO
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		Optional<GameList> result = gameListRepository.findById(id);
		
		// Transforma uma lista de Game em uma GameMinDTO
		GameListDTO dto = new GameListDTO(result.get());
		
		return dto;
	}
}
