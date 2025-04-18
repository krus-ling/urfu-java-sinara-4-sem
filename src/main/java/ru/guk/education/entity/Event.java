package ru.guk.education.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    @JsonBackReference
    private TodoList todoList;

    private String title;

    public Event(TodoList todoList, String title) {
        this.todoList = todoList;
        this.title = title;
    }
}
