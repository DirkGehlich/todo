package com.rnd.exercises.todo.infrastructure;

import com.rnd.exercises.todo.domain.Todo;
import com.rnd.exercises.todo.domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CrudTodoRepository implements TodoRepository {

    @Autowired
    SpringDataCrudTodoRepository repo;

    @Override
    public void add(Todo todo) {
        repo.save(todo);
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        return repo.findById(title);
    }

    @Override
    public Iterable<Todo> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteByTitle(String title) {
        repo.deleteById(title);
    }
}
