package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.UserEntity;

public interface TodoRepository extends JpaRepository<UserEntity, Long> {
	    // 何も書かなくていい
	}
