package com.thoi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {

		Employee emp = new Employee();

		emp.setId(101);
		emp.setName("Rahul");

		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp);
		SpringApplication.run(TodoListApplication.class, args);
	}

}
