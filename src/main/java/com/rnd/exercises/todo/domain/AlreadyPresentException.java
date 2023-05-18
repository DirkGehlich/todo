package com.rnd.exercises.todo.domain;

public class AlreadyPresentException extends RuntimeException {
    AlreadyPresentException(final String message) {
        super(message);
    }
}
