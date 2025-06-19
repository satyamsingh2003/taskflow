package com.satyam.taskflow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyam.taskflow.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);
}
