package com.devspring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspring.dslist.dto.GameListDTO;
import com.devspring.dslist.services.GameListService;

@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll() {
		 List<GameListDTO> list = service.findAll();
		 return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GameListDTO> findAll(@PathVariable Long id) {
		GameListDTO game = service.findById(id);
		 return ResponseEntity.ok().body(game);
	}
}
