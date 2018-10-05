package com.todobackend.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.todobackend.app.entities.ToDo;

public interface ToDoBEDao extends CrudRepository<ToDo, Integer>{

}
