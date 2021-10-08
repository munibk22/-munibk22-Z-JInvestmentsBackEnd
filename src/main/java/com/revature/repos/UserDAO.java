package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Users;

public interface UserDAO extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

	Optional<Users> getByUsername(String username);

	Boolean existsByUsername(String username);
//	public List<User> findAllUsers();
//
//	public User getUser();
//	 User findByUserName(String username);

}
