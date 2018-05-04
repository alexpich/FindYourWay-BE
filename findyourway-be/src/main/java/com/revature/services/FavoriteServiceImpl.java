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
	FavoriteRepository favRepo;
	
	@Override
	public Favorite addFavorite(Favorite newFavorite) {
		for (Favorite fav : findAllFavorites()) {
			if(fav.getFavoritePK().equals(newFavorite.getFavoritePK())) {
				return null;
			}
		}
		
		return favRepo.save(newFavorite);
	}

	@Override
	public List<Favorite> findAllFavorites() {
		return favRepo.findAll();
	}

	@Override
	public List<Favorite> findFavoriteByUserId(Favorite fav) {
		return favRepo.findFavoriteByUserId(fav.getFavoritePK().getUserId());
	}

	@Override
	public Favorite updateFavoriteByUserId(Favorite fav) {
		return favRepo.save(fav);
	}
}