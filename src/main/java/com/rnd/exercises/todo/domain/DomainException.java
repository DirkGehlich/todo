package com.rnd.exercises.todo.domain;

public class DomainException extends RuntimeException {

    DomainException(final String message) {
        super(message);
    }
}
