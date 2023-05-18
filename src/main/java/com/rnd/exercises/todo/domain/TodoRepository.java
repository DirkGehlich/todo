package com.rnd.exercises.todo.domain;

import java.util.Optional;

public interface TodoRepository {

    void add(Todo todo);

    Optional<Todo> findByTitle(String title);
}
