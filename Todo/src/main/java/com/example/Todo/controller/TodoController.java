package com.example.Todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Todo.DTO.todo;
import com.example.Todo.service.TodoServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TodoController {
	
	@Autowired
	private TodoServiceImpl TodoService;
	
	@GetMapping("/")
	public String working() {
		return "hello";
	}
	
	@GetMapping("/getAllTodos")
	public ResponseEntity<List<todo>> getAllTodos(){
		List<todo> todoList = new ArrayList<todo>();
		try {
			todoList = TodoService.getAllItems();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return new ResponseEntity<List<todo>>(todoList,HttpStatus.OK);
	}
	
	@PostMapping("/addTodos")
	public boolean addTodo(@RequestBody todo todo) {
		boolean flag= false;
		try {
			flag = TodoService.addItem(todo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	@GetMapping("/deleteTodo/{id}")
	public boolean deleteTodo(@PathVariable long id) {
		boolean flag = false;
		try {
			flag=TodoService.removeItem(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flag;
	}

}
