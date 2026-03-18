package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.TodoService;

import ch.qos.logback.core.model.Model;


@Controller
public class TodoController {
    private final TodoService todoService;

    /**
     * TodoControllerのコンストラクタ。
     *
     * @param todoService todoに関するビジネスロジックを提供するサービスクラス
     */
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    /**
     * 投稿一覧画面を表示する
     * @param model ビューに渡すモデル
     * @return ビュー名（list.html）
     */
	@GetMapping("/todo/display/list")
	public String displayInitialTodoListScreen() {
		// TODO:投稿一覧の情報をViewに渡す。
		return "todo/list";
	}
    /**
     * 投稿画面を表示する
     * @return ビュー名（registerTodo.html）
     */
	@GetMapping("/todo/display/register")
	public String displayInitialTodoRegisterScreen() {
		return  "todo/register";
	}
    /**
     * 投稿画面入力内容を受け取り、DBに登録する。
     *
     * @param name  フォームから送信された名前
     * @param model ビューに渡すモデル
     * @return ビュー名（list.html）
     */
    @PostMapping("/todo/new/register")
    public String registerTodo(@RequestParam String name, Model model) {
    	//TODO:XSS対策する（エスケープ）
        return "hello";
    }
}



















