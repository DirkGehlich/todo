package com.rnd.exercises.todo.infrastructure.h2;

import com.rnd.exercises.todo.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2TodoRepository extends CrudRepository<Todo, String> {
}
