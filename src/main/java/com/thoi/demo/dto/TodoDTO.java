package com.thoi.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {

	@NotBlank(message = "Title is required")
	@Size(min=3, max=100, message = "Title must be between 3 to 100 characters")
	private String title;
	@NotBlank(message = "Description is required")
	@Size(min= 5, max = 500, message = "Description must be between 5 to 500")
	private String description;
	private boolean completed;
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public boolean isCompleted() {
//		return completed;
//	}
//	public void setCompleted(boolean completed) {
//		this.completed = completed;
//	}
//
//	public TodoDTO() {
//		super();
//	}
//	public TodoDTO(String title, String description, boolean completed) {
//		super();
//		this.title = title;
//		this.description = description;
//		this.completed = completed;
//	}
	
	
}
