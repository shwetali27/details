package com.setup.details.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setup.details.entity.Users;
import com.setup.details.repository.UsersRepo;

@Service
public class UsersDaoService {
	@Autowired
	UsersRepo repo;
	
	public List<Users> getAllUsers(){
		return repo.findAll();
	}

	public Optional<Users> getUser(int id) {
		return repo.findById(id);
	}

	public void saveUser(Users user) {
		repo.save(user);
	}

	public void deleteUser(int id) {
		repo.deleteById(id);
	}
}
