package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite , Integer>{
	//List<Favorite> findFavoriteByFavoritePK(int userId);
}
