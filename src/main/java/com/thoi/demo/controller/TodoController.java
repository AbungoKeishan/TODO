package com.thoi.demo.controller;

import com.thoi.demo.dto.TodoDTO;
import com.thoi.demo.entity.Todo;
import com.thoi.demo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // Home Page
    @GetMapping("/")
    public String home(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {

        model.addAttribute(
                "todos",
                todoService.getAllTodos(page, size, sortBy, sortDir)
        );

        return "index";
    }

    // Show Add Form
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("todoDTO", new TodoDTO());

        return "add-todo";
    }

    // Save Todo
    @PostMapping("/save")
    public String saveTodo(
            @Valid @ModelAttribute("todoDTO") TodoDTO todoDTO,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "add-todo";
        }

        todoService.createTodo(todoDTO);

        return "redirect:/";
    }

    // Show Edit Form
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {

        Todo todo = todoService.getTodoById(id);

        TodoDTO todoDTO = TodoDTO.builder()
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .build();

        model.addAttribute("id", id);
        model.addAttribute("todoDTO", todoDTO);

        return "edit-todo";
    }

    // Update Todo
    @PostMapping("/update/{id}")
    public String updateTodo(
            @PathVariable Long id,
            @Valid @ModelAttribute TodoDTO todoDTO,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "edit-todo";
        }

        todoService.updateTodo(id, todoDTO);

        return "redirect:/";
    }

    // Delete Todo
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return "redirect:/";
    }
}