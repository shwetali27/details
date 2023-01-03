package com.setup.details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setup.details.dao.UsersDaoService;
import com.setup.details.entity.Users;

import jakarta.transaction.Transactional;

@Service
public class UsersService {
	@Autowired
	UsersDaoService usersDao;

	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

	public Users getUser(int id) {
		return usersDao.getUser(id).orElse(null);
	}

	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<Users> saveUser(Users user) {
		user.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
		usersDao.saveUser(user);
		// this will return 201 (Created status in the response)
		return ResponseEntity.created(null).build();
	}

	@Transactional(rollbackOn = Exception.class)
	public void deleteUser(int id) {
		usersDao.deleteUser(id);
	}
}
