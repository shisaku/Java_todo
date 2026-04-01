package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
@Service
public class TodoService {
	private final TodoRepository todoRepository;
	private static final Logger log = LoggerFactory.getLogger(TodoService.class);
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
    		log.error("DB登録失敗: {}", e.getMessage());
    		throw new RuntimeException("登録に失敗しました", e);
    	}
    }
    /**
     * 投稿内容一覧を取得する
      * @return 全TodoエンティティのList。0件の場合は空のListを返す。
     * @throws RuntimeException DB登録に失敗した場合
     */
    public List<TodoEntity> getTodolistAll()throws RuntimeException{
    	try {
    		List<TodoEntity> todos = todoRepository.findAll();
    		return todos;
       	}catch(DataAccessException e) {
    		log.error("DB取得失敗: {}", e.getMessage());
    		throw new RuntimeException("取得に失敗しました", e);
    	}
    }















}
