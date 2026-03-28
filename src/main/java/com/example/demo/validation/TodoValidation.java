package com.example.demo.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoValidation {
	@NotBlank
	@Size(max = 255)
	private String content;
    // getter
    public String getContent() {
        return content;
    }

    // setter
    public void setContent(String content) {
        this.content = content;
    }
}
