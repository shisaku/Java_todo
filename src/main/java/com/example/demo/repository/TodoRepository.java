package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	}
