package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TodoController {
    /**
     * 投稿一覧画面を表示する
     * @param model ビューに渡すモデル
     * @return ビュー名（list.html）
     */
	@GetMapping("/todo/list")
	public String displayInitialTodoListScreen() {
		// TODO:投稿一覧の情報をViewに渡す。
		return "todo/list";
	}
    /**
     * 投稿画面を表示する
     * @return ビュー名（registerTodo.html）
     */
	@GetMapping("/todo/register")
	public String displayInitialTodoRegisterScreen() {
		return  "todo/register";
	}
}





