//package com.thoi.demo.controller;
//
//
//import jakarta.validation.Valid;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.thoi.demo.TodoListApplication;
//import com.thoi.demo.dto.TodoDTO;
//import com.thoi.demo.entity.Todo;
//import com.thoi.demo.service.TodoService;
//
//import lombok.RequiredArgsConstructor;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/todo")
//@RequiredArgsConstructor
//public class RestAPI_TodoController {
//
//    private final TodoListApplication todoListApplication;
//
//	private final TodoService todoService;
//
////    TodoController(TodoListApplication todoListApplication) {
////        this.todoListApplication = todoListApplication;
////    }
//
//	@PostMapping
//	public ResponseEntity<Todo> createTodo(@Valid @RequestBody TodoDTO todoDTO){
//		return ResponseEntity.ok(todoService.createTodo(todoDTO));
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
//		return ResponseEntity.ok(todoService.getTodoById(id));
//	}
//
////	@GetMapping
////	public ResponseEntity<List<Todo>> getAllTodos() {
////		return ResponseEntity.ok(todoService.getAllTodos());
////	}
//
//	@GetMapping
//	public ResponseEntity<Page<Todo>> getAllTodos(
//			@RequestParam(defaultValue = "0") int page,
//			@RequestParam(defaultValue = "5") int size,
//			@RequestParam(defaultValue = "id") String sortBy,
//			@RequestParam(defaultValue = "asc") String sortDir){
//
//		return ResponseEntity.ok(
//				todoService.getAllTodos(page, size, sortBy, sortDir)
//		);
//	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody TodoDTO todoDTO){
//		return ResponseEntity.ok(todoService.updateTodo(id, todoDTO));
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteTodo(@PathVariable Long id){
//		todoService.deleteTodo(id);
//		return ResponseEntity.ok("Todo deleted successfully!");
//	}
//}
