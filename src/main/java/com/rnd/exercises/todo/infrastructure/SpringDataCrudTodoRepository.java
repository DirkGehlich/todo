package com.rnd.exercises.todo.infrastructure;

import com.rnd.exercises.todo.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCrudTodoRepository extends CrudRepository<Todo, String> {
}
