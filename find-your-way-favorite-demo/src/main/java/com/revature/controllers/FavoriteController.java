package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Favorite;
import com.revature.services.FavoriteService;

@CrossOrigin
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Favorite addFavorite(@Valid @RequestBody Favorite newFavorite) {
		return favoriteService.addFavorite(newFavorite);		
	}
	
	@PatchMapping(produces="application/json", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Favorite updateFavorite(@Valid @RequestBody Favorite updateFavorite) {
		return favoriteService.updateFavoriteByUserId(updateFavorite);		
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favorite> findAllFavorites(){
		return favoriteService.findAllFavorites();
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favorite> findFavoriteByUserId(@Valid @RequestBody Favorite fav){
		return favoriteService.findFavoriteByUserId(fav);
	}
}
