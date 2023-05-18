package com.rnd.exercises.todo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainTodoService implements TodoService{

    TodoRepository todoRepository;

    @Autowired
    public DomainTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void add(Todo todo) {
        todoRepository.findByTitle(todo.getTitle()).ifPresent(t -> {throw new AlreadyPresentException("Todo already present!");});
        todoRepository.save(todo);
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

    @Override
    public void updateByTitle(String title, Todo todo) {
        todoRepository.findByTitle(title).orElseThrow(() -> new TodoNotFoundException("Can't find todo to update"));

        if (!title.equals(todo.getTitle())) {
            todoRepository.findByTitle(todo.getTitle()).ifPresent(t -> {throw new AlreadyPresentException("New title already present!");});
            deleteByTitle(title);
        }

        todoRepository.save(todo);
    }
}
