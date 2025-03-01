package com.example.Todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Todo.DTO.todo;

@Repository
public interface TodoDAO extends JpaRepository<todo, Long>{

}
