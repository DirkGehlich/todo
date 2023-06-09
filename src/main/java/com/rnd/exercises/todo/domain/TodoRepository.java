package com.rnd.exercises.todo.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    void save(Todo todo);

    Optional<Todo> findByTitle(String title);

    Iterable<Todo> findAll();

    void deleteByTitle(String title);
}
