package com.example.demo.service;

import com.example.demo.repository.TodoRepository;

public class TodoService {
	private final TodoRepository todoRepository;
    /**
     * TodoServiceのコンストラクタ。
     *
     * @param todoService todoに関するビジネスロジックを提供するサービスクラス
     */
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
