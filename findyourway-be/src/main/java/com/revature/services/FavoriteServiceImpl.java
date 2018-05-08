package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Favorite;
import com.revature.repositories.FavoriteRepository;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Override
	public Favorite addFavorite(Favorite newFavorite) {
		for (Favorite fav : findAllFavorites()) {
			if(fav.getFavoritePK().equals(newFavorite.getFavoritePK())) {
				return null;
			}
		}
		return favoriteRepository.save(newFavorite);
	}

	@Override
	public List<Favorite> findAllFavorites() {
		return favoriteRepository.findAll();
	}

	@Override
	public List<Favorite> findFavoriteByUserId(int userId) {
		
		List<Favorite> favList = favoriteRepository.findAll();
		List<Favorite> myList = new ArrayList<Favorite>();
		
		for (Favorite favorite : favList) {
			if(favorite.getFavoritePK().getUserId() == (userId)) {
				myList.add(favorite);
			}
		}
		return myList;
	}

	@Override
	public boolean deleteFavoriteByFavoritePK(Favorite fav) {
		
		favoriteRepository.delete(fav);
		
		if(findFavoriteByUserId(fav.getFavoritePK().getUserId()) != null) {
			return false;
		}
		return true;
	}
}
