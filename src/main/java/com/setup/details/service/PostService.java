package com.setup.details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setup.details.dao.PostsDaoService;
import com.setup.details.dao.UsersDaoService;
import com.setup.details.entity.Posts;
import com.setup.details.entity.Users;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	@Autowired
	PostsDaoService postsDao;
	
	@Autowired
	UsersDaoService usersDao;

	public List<Posts> getAllPosts() {
		return postsDao.getAllUserPosts();
	}

	public List<Posts> getAllPostsByUser(int id) {
		return postsDao.getAllUserPostsByUser(id);
	}

	public Posts getUserPostDetails(int userId, int postId) {
		return postsDao.getUserPostDetails(userId, postId).orElse(null);
	}

	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<Posts> savePost(int userid, Posts post) {
		Users user = usersDao.getUser(userid);
		post.setUser(user);
		post.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
		Posts newPost = postsDao.savePost(post);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//	            .buildAndExpand(newPost.getPostId()).toUri();
		return ResponseEntity.created(null).build();
	}

	@Transactional(rollbackOn = Exception.class)
	public void deletePost(int userId, int postId) {
		postsDao.deletePost(userId, postId);
	}
}
