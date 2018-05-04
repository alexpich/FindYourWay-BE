package com.revature.services;

import java.util.List;

import com.revature.models.Favorite;

public interface FavoriteService {
	public Favorite addFavorite(Favorite newFavorite);
	public List<Favorite> findAllFavorites();
	public List<Favorite> findFavoriteByUserId(Favorite fav);
	public Favorite updateFavoriteByUserId(Favorite fav);
}
