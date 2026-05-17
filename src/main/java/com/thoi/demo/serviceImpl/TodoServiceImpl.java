package com.thoi.demo.serviceImpl;

import java.util.List;

import com.thoi.demo.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thoi.demo.dto.TodoDTO;
import com.thoi.demo.entity.Todo;
import com.thoi.demo.repository.TodoRepository;
import com.thoi.demo.service.TodoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
//	public TodoServiceImpl(TodoRepository todoRepository) {
//		this.todoRepository = todoRepository;
//	}
	@Override
	public Todo createTodo(TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		Todo todo = Todo.builder()
					.title(todoDTO.getTitle())
					.description(todoDTO.getDescription())
					.completed(todoDTO.isCompleted())
					.build();
		return todoRepository.save(todo);
	}

	@Override
	public Page<Todo> getAllTodos(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc")
				? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);
		return todoRepository.findAll(pageable);
	}

//	@Override
//	public List<Todo> getAllTodos() {
//		// TODO Auto-generated method stub
//		return todoRepository.findAll();
//	}

	@Override
	public Todo getTodoById(Long id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
	}

	@Override
	public Todo updateTodo(Long id, TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found"));
		todo.setTitle(todoDTO.getTitle());
		todo.setDescription(todoDTO.getDescription());
		todo.setCompleted(todoDTO.isCompleted());
		return  todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
		todoRepository.delete(todo);
	}

}
