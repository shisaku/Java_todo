package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.TodoEntity;
import com.example.demo.service.TodoService;
import com.example.demo.validation.TodoValidation;



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
     * システムエラー画面を表示する
     * @return ビュー名（systemError.html）
     */
	@GetMapping("/todo/display/systemError")
	public String displayInitialSystemErrorScreen() {
		return  "todo/systemError";
	}
    /**
     * 投稿画面入力内容を受け取り、DBに登録する。
     *
     * @param name  フォームから送信された名前
     * @param model ビューに渡すモデル
     * @return ビュー名（list.html）
     * 		   バリデーションエラー時はTODO投稿画面へフォワード
     *         システムエラー時はシステムエラー画面へリダイレクト
     */
    @PostMapping("/todo/new/register")
    public String registerTodo(@Valid @ModelAttribute TodoValidation todoValidation,BindingResult result,@ModelAttribute TodoEntity todoEntity,RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "todo/register"; // エラーがあれば入力画面に戻る
        }
    	try {
    		todoService.registerTodo(todoEntity);
    		return "redirect:/todo/display/list";
    	}catch(RuntimeException e) {
    		redirectAttrs.addFlashAttribute("errorMessage", e.getMessage());
    		return  "redirect:/todo/display/systemError";
    	}
    }
}



















