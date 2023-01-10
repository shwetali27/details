package com.setup.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setup.details.dto.UsersNameOnly;
import com.setup.details.entity.Users;
import com.setup.details.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/setup/details/")
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping(value="users")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	/**
	 *  -- Implementing HATEOAS to get all users url link in the users details
	 *  link should be .../users
	 * @param id
	 * @return
	 */
	// using path parameter - id. 
	@GetMapping(value="users/{id}")
	public EntityModel<Users> getUserDetails(@PathVariable int id) {
		return usersService.getUser(id);
	}
	
	@PostMapping(value="users/save")
	public ResponseEntity<Users> saveUser(@Valid @RequestBody Users user) {
		return usersService.saveUser(user);
	}

	@DeleteMapping(value="users/{id}/delete")
	public void deleteUser(@PathVariable int id){
		usersService.deleteUser(id);
	}
	
	@PutMapping(value="users/{id}")
	public void updateUser(@PathVariable int id, @RequestBody Users user){
		usersService.updateUser(id, user);
	}
	
	@PatchMapping(value="users/{id}")
	public void updateUserPartial(@PathVariable int id, @RequestBody UsersNameOnly user){
		usersService.updateUserName(id, user);
	}
}
