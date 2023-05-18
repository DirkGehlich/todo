package com.rnd.exercises.todo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainTodoService implements TodoService{

    TodoRepository todoRepository;

    @Autowired
    public DomainTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void add(Todo todo) {
        todoRepository.findByTitle(todo.getTitle()).ifPresent(t -> {throw new AlreadyPresentException("Todo already present!");});
        todoRepository.add(todo);
    }

    @Override
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public void deleteByTitle(String title) {
        todoRepository
                .findByTitle(title)
                .ifPresent(b -> todoRepository.deleteByTitle(title));
    }
}
