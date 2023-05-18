package com.rnd.exercises.todo.application;

import com.rnd.exercises.todo.domain.Todo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TodoControllerTest {

    private final static String API_ROOT = "http://localhost:8081/todos";


    private Todo createRandomTodo() {
        return new Todo(randomAlphabetic(10), randomAlphabetic(20));
    }

    private void addTodo(Todo todo) {
        RestAssured.given().contentType(ContentType.JSON).body(todo).post(API_ROOT);
    }


    @Test
    public void contextLoads() {
    }

    @Test
    void givenEmptyTodoList_whenAddingRandomTodo_Return201Created() {
        Todo todo = createRandomTodo();

        Response response = RestAssured.given().contentType(ContentType.JSON).body(todo).post(API_ROOT);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    void givenExistingTodo_whenAddingTodoWithSameTitle_Return400BadRequest() {
        Todo todo = createRandomTodo();
        addTodo(todo);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(todo).post(API_ROOT);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    void givenNoTodosInList_whenDeletingTodo_Return200Ok() {
        Todo todo = createRandomTodo();

        Response response = RestAssured.given().contentType(ContentType.JSON).delete(API_ROOT + "/" + todo.getTitle());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    void givenTodoInList_whenDeletingTodo_DeleteAndReturn200Ok() {
        Todo todo = createRandomTodo();
        addTodo(todo);

        Response response = RestAssured.given().contentType(ContentType.JSON).delete(API_ROOT + "/" + todo.getTitle());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    void givenNoTodosInList_whenUpdatingTodo_Return404NotFound() {
        Todo todo = createRandomTodo();

        Response response = RestAssured.given().contentType(ContentType.JSON).body(todo).put(API_ROOT + "/" + todo.getTitle());

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}