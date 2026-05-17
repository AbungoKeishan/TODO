package com.thoi.demo.service;

import java.util.List;

import com.thoi.demo.dto.TodoDTO;
import com.thoi.demo.entity.Todo;
import org.springframework.data.domain.Page;

public interface TodoService {

	Todo createTodo(TodoDTO todoDTO);
//	List<Todo> getAllTodos();
	Page<Todo> getAllTodos(int page, int size, String sortBy, String sortDir);
	Todo getTodoById(Long id);
	Todo updateTodo(Long id, TodoDTO todoDTO);
	void deleteTodo(Long id);

}
