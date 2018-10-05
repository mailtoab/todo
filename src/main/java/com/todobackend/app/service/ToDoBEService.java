package com.todobackend.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todobackend.app.dao.ToDoBEDao;
import com.todobackend.app.entities.ToDo;

@Service
public class ToDoBEService {

	@Autowired
	private ToDoBEDao toDoBEDao;

	public Iterable<ToDo> createToDo(ToDo ticket) {
		toDoBEDao.save(ticket);
		return getAllToDos();
	}

	// public ToDo getToDoById(Integer ticketId) {
	// return toDoBEDao.findOne(ticketId);
	// }

	public boolean getToDoByTask(String task) {
		if ("task".equals(task))
			return true;
		return false;
	}

	public Iterable<ToDo> getAllToDos() {
		return toDoBEDao.findAll();
	}
	//
	// public void deleteToDo(Integer ticketId) {
	// toDoBEDao.delete(ticketId);
	// }

	// public ToDo updateToDo(Integer ticketId, String newEmail) {
	// ToDo ticketFromDb = toDoBEDao.findOne(ticketId);
	// ticketFromDb.setEmail(newEmail);
	// ToDo upadedTicket = toDoBEDao.save(ticketFromDb);
	// return upadedTicket;
	// }
}
