package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repos.UserDAO;

@Service
public class UserService implements UserDetailsService {

	private UserDAO userDao;
	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public UserService() {
		super();
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public boolean saveUser(User user) {
		userDao.save(user);
		return true;
	}

	public void deleteUser(User user) {
		userDao.delete(user);

	}

	public void updateUser(User user) {
		userDao.save(user);

	}

	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);
		if (user == null) {
			log.warn("404 User not found.");
		}

		return new UserPrincipal(user);
	}

}
