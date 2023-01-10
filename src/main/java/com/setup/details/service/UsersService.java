package com.setup.details.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setup.details.controller.UsersController;
import com.setup.details.dao.UsersDaoService;
import com.setup.details.dto.UsersNameOnly;
import com.setup.details.entity.Users;

import jakarta.transaction.Transactional;

@Service
public class UsersService {
	@Autowired
	UsersDaoService usersDao;

	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

	/**
	 * Get User details with all users url added in the link by using HATEOAS
	 * @param id
	 * @return
	 */
	public EntityModel<Users> getUser(int id) {
		Users user =  usersDao.getUser(id);
		EntityModel<Users> entityModel = EntityModel.of(user);
		/*Note:  instead of hard coding /users link, we are giving the method which is mapped
		 to this url in the UsersController 
		 */
		WebMvcLinkBuilder link = linkTo(methodOn(UsersController.class).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
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
	
	@Transactional(rollbackOn = Exception.class)
	public void updateUser(int userId, Users user) {
		user.setUserId(userId);
		usersDao.updateUser(user);
	}

	public void updateUserName(int id, UsersNameOnly user) {
		usersDao.updateUserName(id, user.getName());
	}
}
