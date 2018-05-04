package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.revature.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite ,Integer>{
	List<Favorite> findFavoriteByUserId(int userId);
}
