package com.rnd.exercises.todo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {

    @Getter
    @Id
    private String title;

    @Getter
    @Setter
    private String text;
}
