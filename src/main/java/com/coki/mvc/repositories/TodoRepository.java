package com.coki.mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coki.mvc.domains.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
