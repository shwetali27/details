package com.setup.details.dao;

import java.util.List;

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

	public Users getUser(int id) {
		return repo.findById(id).get();
	}

	public void saveUser(Users user) {
		repo.save(user);
	}

	public void deleteUser(int id) {
		repo.deleteById(id);
	}

	public void updateUser(Users user) {
		if(repo.existsById(user.getUserId())) {
			repo.save(user);
		}
	}

	public void updateUserName(int id, String name) {
		if(repo.existsById(id)) {
			repo.UpdateName(id, name);
		}
	}
}
