package com.coki.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coki.mvc.domains.Todo;
import com.coki.mvc.services.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@GetMapping("/")
	public Iterable<Todo> home() {
		return todoService.list();
	}
	@GetMapping("/view/{id}")
	public Todo view(@PathVariable("id") Long id) {
		return todoService.get(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Todo create(@RequestBody Todo todo) {
		return todoService.save(todo);
	}
	@PutMapping("/update/{id}")
	public Todo update(@PathVariable("id") Long id,@RequestBody Todo todo) {
		Todo t1=todoService.update(id, todo);
		return todoService.save(t1);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		todoService.delete(id);
	}

}
