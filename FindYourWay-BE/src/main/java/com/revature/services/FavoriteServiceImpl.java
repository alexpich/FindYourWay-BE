package com.revature.services;

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
	public List<Favorite> findFavoriteByFavoritePK(Favorite fav) {
		return favoriteRepository.findFavoriteByFavoritePK(fav.getFavoritePK().getUserId());
	}

	@Override
	public Favorite updateFavoriteByFavoritePK(Favorite fav) {
		return favoriteRepository.save(fav);
	}

}
