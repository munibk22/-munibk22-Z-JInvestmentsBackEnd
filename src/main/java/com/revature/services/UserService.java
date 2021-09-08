package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserDAO userDao;

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

}
