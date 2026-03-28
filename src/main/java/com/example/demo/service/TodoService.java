package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.dao.DataAccessException;
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
    /**
     * 投稿内容を登録する
     * @param todoEntity 投稿内容
     * @return ビュー名（list.html）
     * @throws RuntimeException DB登録に失敗した場合
     */
    public void registerTodo(TodoEntity todoEntity) throws RuntimeException{
    	try {
    		//TODO:ユーザIDを取得する
    		//多分こんな感じ
    		//UserEntity user = userRepository.findByUsername(loginUsername);
    	    todoEntity.setCreatedAt(LocalDateTime.now());
    	    todoEntity.setUpdatedAt(LocalDateTime.now());
    	    //TODO:セッションより取得する
    	    todoEntity.setCreatedBy("admin");
    	    //TODO:セッションより取得する
    	    todoEntity.setUpdatedBy("admin");
    	    todoEntity.setDone(false);
    		todoRepository.save(todoEntity);
//    		throw new DataAccessResourceFailureException("テスト用エラー");
    	}catch(DataAccessException e) {
    		throw new RuntimeException("登録に失敗しました", e);
    	}
    }
}
