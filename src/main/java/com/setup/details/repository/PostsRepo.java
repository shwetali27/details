package com.setup.details.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.setup.details.entity.Posts;

public interface PostsRepo extends JpaRepository<Posts, Integer>{

	@Transactional
	@Query(value = "select * from posts where user_id = ?1", nativeQuery = true)
	public List<Posts> getUsersPost(int userid);
	
	@Transactional
	@Query(value = "select * from posts where user_id = ?1 and post_id = ?2", nativeQuery = true)
	public Optional<Posts> getUsersPostDetails(int userId, int postId);

	@Transactional
	@Modifying
	@Query(value= "delete from posts where user_id = ?1 and post_id = ?2", nativeQuery = true)
	public void deleteUsersPost(int userId, int postId);
	
	
}
