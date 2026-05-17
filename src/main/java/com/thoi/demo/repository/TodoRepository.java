package com.thoi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoi.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
