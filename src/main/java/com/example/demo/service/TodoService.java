package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
@Service
public class TodoService {
	private final TodoRepository todoRepository;
    /**
     * TodoServiceのコンストラクタ。
     *
     * @param TodoRepositoryに関するビジネスロジックを提供するサービスクラス
     */
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public void registerTodo(TodoEntity todoEntity) {
    	todoRepository.save(todoEntity);
    }
}
