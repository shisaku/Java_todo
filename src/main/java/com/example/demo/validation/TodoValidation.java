package com.example.demo.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoValidation {
	@NotBlank(message = "タイトルは必須です")
	@Size(max = 255, message = "255文字以内で入力してください")
	private String content;
}
