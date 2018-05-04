package com.revature.models;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FAVORITES")
public class Favorite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId   
	private FavoritePK favoritePK;

	public Favorite() {
		super();
	}

	public FavoritePK getFavoritePK() {
		return favoritePK;
	}

	public void setFavoritePK(FavoritePK favoritePK) {
		this.favoritePK = favoritePK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favoritePK == null) ? 0 : favoritePK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (favoritePK == null) {
			if (other.favoritePK != null)
				return false;
		} else if (!favoritePK.equals(other.favoritePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorite [favoritePK=" + favoritePK + "]";
	}	
}
