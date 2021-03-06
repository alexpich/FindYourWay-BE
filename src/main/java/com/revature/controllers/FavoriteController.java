package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favorite> findAllFavorites(){
		return favoriteService.findAllFavorites();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favorite> findFavoriteByFavoritePK(@PathVariable("id") int userId){
		
		return favoriteService.findFavoriteByUserId(userId);
	}
	
	@DeleteMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteFavoriteByFavoritePK(@Valid @RequestBody Favorite oldFavorite) {
		return favoriteService.deleteFavoriteByFavoritePK(oldFavorite);
	}
}
