package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Brandon Semba
 * 
 * Model that contains information for a user of the application
 *
 */
@Component
@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="roleId")
	@NotNull
	@Min(1)
	@Max(2)
	private Integer roleId;
	
	@Column(name="username")
	@NotNull
	private String username;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="firstname")
	@NotNull
	private String firstname;
	
	@Column(name="lastname")
	@NotNull
	private String lastname;
	
	@Column(name="location")
	@NotNull
	private String location;
	
	@Column(name="points")
	@NotNull
	private Integer points;

	public User() {
	}

	public User(Integer userId, @NotNull @Min(1) @Max(2) Integer roleId, @NotNull String username,
			@NotNull String password, @NotNull String email, @NotNull String firstname, @NotNull String lastname,
			@NotNull String location, @NotNull Integer points) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.points = points;
	}

	public User(@NotNull @Min(1) @Max(2) Integer roleId, @NotNull String username, @NotNull String password, @NotNull String email, @NotNull String firstname,
			@NotNull String lastname, @NotNull String location, @NotNull Integer points) {
		super();
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.points = points;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", roleId=" + roleId + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", location=" + location
				+ ", points=" + points + "]";
	}
}