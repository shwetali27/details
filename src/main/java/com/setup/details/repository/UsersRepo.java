package com.setup.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.setup.details.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "Update users set user_name = ?2 where user_id = ?1", nativeQuery = true)
	public int UpdateName(int id, String name);
}
