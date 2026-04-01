package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

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
	public String displayInitialTodoListScreen(Model model,RedirectAttributes redirectAttrs) {
		// TODO:投稿一覧の情報をViewに渡す。
		try {
			log.info("投稿一覧表示処理 開始");
			List<TodoEntity> todos = todoService.getTodolistAll();
			model.addAttribute("todos", todos);
			return "todo/list";
		}catch(RuntimeException e) {
    		redirectAttrs.addFlashAttribute("errorMessage", e.getMessage());
    		return  "redirect:/todo/display/systemError";
    	}finally {
    		log.info("投稿一覧表示処理 終了");
    	}
	}
    /**
     * 投稿画面を表示する
     * @return ビュー名（registerTodo.html）
     *         システムエラー時はシステムエラー画面へリダイレクト
     */
	@GetMapping("/todo/display/register")
	public String displayInitialTodoRegisterScreen(Model model) {
			model.addAttribute("todoValidation",new TodoValidation());
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
    public String registerTodo(@Valid @ModelAttribute TodoValidation todoValidation,BindingResult result,@ModelAttribute TodoEntity todoEntity,RedirectAttributes redirectAttrs,Model model) {
        // th:textとすると自動的にエスケープしてくれる
    	log.info("新規投稿DB登録処理 開始");
    	if (result.hasErrors()) {
    		log.warn("新規投稿DB登録処理 バリデーションエラー");
    		log.info("新規投稿DB登録処理 終了");
            return "todo/register"; // エラーがあれば入力画面に戻る
        }
    	try {
    		todoService.registerTodo(todoEntity);
    		return "redirect:/todo/display/list";
    	}catch(RuntimeException e) {
    		redirectAttrs.addFlashAttribute("errorMessage", e.getMessage());
    		return  "redirect:/todo/display/systemError";
    	}finally {
    		log.info("新規投稿DB登録処理 終了");
    	}
    }
}



















