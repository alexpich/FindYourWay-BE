package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Favorite;
import com.revature.models.FavoritePK;

public interface FavoriteRepository extends JpaRepository<Favorite , FavoritePK>{
	List<Favorite> findFavoriteByFavoritePK(int userId);
}
