package com.todobackend.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todobackend.app.entities.ToDo;
import com.todobackend.app.service.ToDoBEService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api/toDos")
public class ToDoBEController {

	@Autowired
	private ToDoBEService toDoBEService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public Iterable<ToDo> createToDo(@RequestBody ToDo toDo){
		return toDoBEService.createToDo(toDo);
	}
	
	@RequestMapping(value = "/tempcreate", method = RequestMethod.GET, headers = "Accept=application/json")
	public Iterable<ToDo> create(){
		ToDo toDo=new ToDo();
		toDo.setTask("Task1");
		toDo.setStatus("Pending");
		return toDoBEService.createToDo(toDo);
	}
	
//	@GetMapping(value="/toDo/{toDoId}")
//	public ToDo getToDoById(@PathVariable("toDoId")Integer toDoId){
//		return toDoBEService.getToDoById(toDoId);
//	}
	
	@GetMapping(value="/toDo/{task}")
	public boolean getToDoByTask(@PathVariable("task")String task){
		return toDoBEService.getToDoByTask(task);
	}
	
	@RequestMapping(value = "/toDo/allToDos", method = RequestMethod.GET, headers = "Accept=application/json")
	public Iterable<ToDo> getAllToDos(){
		return toDoBEService.getAllToDos();
	}
//	
//	@DeleteMapping(value="/toDo/{toDoId}")
//	public void deleteToDo(@PathVariable("toDoId")Integer toDoId){
//		toDoBEService.deleteToDo(toDoId);
//	}
	
//	@PutMapping(value="/toDo/{toDoId}/{newEmail:.+}")
//	public ToDo updateToDo(@PathVariable("toDoId")Integer toDoId,@PathVariable("newEmail")String newEmail){
//		return toDoBEService.updateToDo(toDoId,newEmail);
//	}
}
