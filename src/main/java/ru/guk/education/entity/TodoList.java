package ru.guk.education.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "todo_list")
@Entity
public class TodoList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Event> events = new HashSet<>();

    public TodoList(Set<Event> events, String name) {
        this.events = events;
        this.name = name;
    }
}
