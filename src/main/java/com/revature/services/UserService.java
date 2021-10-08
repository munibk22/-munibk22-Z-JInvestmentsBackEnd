package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
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

	public List<Users> getAllUsers() {
		return userDao.findAll();
	}

	public boolean saveUser(Users user) {
		userDao.save(user);
		return true;
	}

	public void deleteUser(Users user) {
		userDao.delete(user);

	}

	public void updateUser(Users user) {
		userDao.save(user);

	}

	public Users getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userDao.findByUsername(username);
		if (user == null) {
			log.error("404 User not found.");
		}

		return new UserPrincipal(user);
	}

	public Users loadUserByUsername2(String username)throws UsernameNotFoundException  {
		Users user =userDao.findByUsername(username);
		return user;
	}

}
