package com.example.Todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Todo.DTO.todo;
import com.example.Todo.dao.TodoDAO;

@Service
public class TodoServiceImpl implements TodoService {
	
//	@Autowired
	private TodoDAO DAO;
	
	@Autowired
	public TodoServiceImpl(TodoDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	public List<todo> getAllItems() {
		return DAO.findAll();
	}

	@Override
	public boolean addItem(todo item) {
		// TODO Auto-generated method stub
		try {
			DAO.save(item);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean removeItem(Long Id) {
		// TODO Auto-generated method stub
		try {
			DAO.deleteById(Id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
