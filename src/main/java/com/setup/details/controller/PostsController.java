package com.setup.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.setup.details.entity.Posts;
import com.setup.details.service.PostService;

@RestController
@RequestMapping("/setup/details/")
public class PostsController {

	@Autowired
	PostService postService;
	
	@GetMapping("posts")
	public List<Posts> getAllPost() {
		return postService.getAllPosts();
	}

	@GetMapping("users/{id}/posts")
	public List<Posts> getUsersPost(@PathVariable int id) {
		return postService.getAllPostsByUser(id);
	}

	@GetMapping("users/{id}/posts/{postid}")
	public Posts getUsersPost(@PathVariable int id, @PathVariable int postid) {
		return postService.getUserPostDetails(id, postid);
	}

	@PostMapping("users/{id}/posts/save")
	public void saveUserPost(@PathVariable int id, @RequestBody Posts post) {
		postService.savePost(id, post);
	}

	// using path variable (id),
	// @RequestParam(same as @QueryParam only providers/imports are diff)
	// eg: http://localhost:8077/setup/details/users/1/posts?postId=2
	@DeleteMapping("users/{userId}/posts")
	public void deleteUserPost(@PathVariable int userId, @RequestParam("postId") int postId) {
		postService.deletePost(userId, postId);
	}
}
