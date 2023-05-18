package com.rnd.exercises.todo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    void add(Todo todo);

    Iterable<Todo> getAll();

    void deleteByTitle(String title);
}
