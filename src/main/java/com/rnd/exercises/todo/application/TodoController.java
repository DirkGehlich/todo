package com.rnd.exercises.todo.application;

import com.rnd.exercises.todo.domain.Todo;
import com.rnd.exercises.todo.domain.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody final Todo todo) {
        todoService.add(todo);
    }
}
