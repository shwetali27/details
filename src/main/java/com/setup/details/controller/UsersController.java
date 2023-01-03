package com.setup.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setup.details.entity.Users;
import com.setup.details.service.UsersService;

@RestController
@RequestMapping("/setup/details/")
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping(value="users")
	public List<Users> getStudents(){
		return usersService.getAllUsers();
	}
	
	// using path parameter - id. 
	@GetMapping(value="users/{id}")
	public Users getUserDetails(@PathVariable int id) {
		return usersService.getUser(id);
	}
	
	@PostMapping(value="users/save")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) {
		return usersService.saveUser(user);
	}

	@DeleteMapping(value="users/{id}/delete")
	public void deleteUser(@PathVariable int id){
		usersService.deleteUser(id);
	}
	
}
