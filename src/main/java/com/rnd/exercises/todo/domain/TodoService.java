package com.rnd.exercises.todo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {

    void add(Todo todo);
}
