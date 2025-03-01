package com.example.Todo.service;

import java.util.List;

import com.example.Todo.DTO.todo;

public interface TodoService {
	
	public List<todo> getAllItems();
	
	public boolean addItem(todo item);
	
	public boolean removeItem(Long Id);

}
