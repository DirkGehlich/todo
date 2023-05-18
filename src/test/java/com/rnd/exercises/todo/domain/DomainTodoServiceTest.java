package com.rnd.exercises.todo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DomainTodoServiceTest {

    private TodoRepository todoRepository;
    private DomainTodoService todoService;

    private Todo createRandomTodo() {
        return new Todo(randomAlphabetic(10), randomAlphabetic(20));
    }

    @BeforeEach
    void setUp() {
        todoRepository = mock(TodoRepository.class);
        todoService = new DomainTodoService(todoRepository);
    }

    @Test
    void givenNoTodosInList_whenGetAll_thenReturnEmptyList() {
        List<Todo> existingTodos = new ArrayList<>();
        when(todoRepository.findAll()).thenReturn(existingTodos);

        Iterable<Todo> todos = todoService.getAll();

        assertIterableEquals(todos, existingTodos);
    }

    @Test
    void givenTodoInList_whenGetAll_thenReturnList() {
        Todo newTodo = createRandomTodo();
        Todo anotherTodo = createRandomTodo();
        List<Todo> existingTodos = List.of(newTodo, anotherTodo);
        when(todoRepository.findAll()).thenReturn(existingTodos);

        Iterable<Todo> todos = todoService.getAll();

        assertIterableEquals(todos, existingTodos);
    }

    @Test
    void givenEmptyTodoList_whenNewUniqueTodoAdded_thenSaveInRepository() {
        Todo newTodo = createRandomTodo();
        when(todoRepository.findByTitle(newTodo.getTitle())).thenReturn(Optional.empty());

        todoService.add(newTodo);

        verify(todoRepository).add(newTodo);
    }

    @Test
    void givenTodoInList_whenTodoAddedWithSameTitle_thenThrowException() {
        Todo newTodo = createRandomTodo();
        when(todoRepository.findByTitle(newTodo.getTitle())).thenReturn(Optional.of(newTodo));

        final Executable executable = () -> todoService.add(newTodo);

        assertThrows(AlreadyPresentException.class, executable);
    }
}