package com.setup.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setup.details.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
}
