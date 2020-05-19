package com.coki.mvc.services;

import org.springframework.stereotype.Service;

import com.coki.mvc.domains.Todo;
import com.coki.mvc.repositories.TodoRepository;

@Service
public class TodoService {
	private TodoRepository todorepo;

	public TodoService(TodoRepository todorepo) {
		super();
		this.todorepo = todorepo;
	}
	public Iterable<Todo> list(){
		return todorepo.findAll();
		
	}
	public Todo get(Long id) {
		return todorepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"+id));
	}
	
	public Todo save(Todo todo) {
		return todorepo.save(todo);
	}

	public Todo update(Long id,Todo todo) {
		Todo update=todorepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid todo id"+id));
		update.setTitle(todo.getTitle());
		update.setCompleted(todo.getCompleted());
		return todorepo.save(update);
		
	}
	public void delete(Long id) {
		todorepo.deleteById(id);
		
	}
}
