package com.rnd.exercises.todo.infrastructure.h2;

import com.rnd.exercises.todo.domain.Todo;
import com.rnd.exercises.todo.domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class H2TodoRepository implements TodoRepository {

    @Autowired SpringDataH2TodoRepository repo;

    @Override
    public void add(Todo todo) {
        repo.save(todo);
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        return repo.findById(title);
    }
}
