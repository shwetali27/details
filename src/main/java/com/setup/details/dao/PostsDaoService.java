package com.setup.details.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setup.details.entity.Posts;
import com.setup.details.repository.PostsRepo;

@Service
public class PostsDaoService {
	@Autowired
	PostsRepo repo;
	
	public List<Posts> getAllUserPosts(){
		return repo.findAll();
	}
	
	public List<Posts> getAllUserPostsByUser(int userId){
		return repo.getUsersPost(userId);
	}

	public Optional<Posts> getUserPostDetails(int userId, int postId) {
		return repo.getUsersPostDetails(userId, postId);
	}

	public Posts savePost(Posts post) {
		return repo.save(post);
	}

	public void deletePost(int userId, int postId) {
		repo.deleteUsersPost(userId, postId);
	}
}
