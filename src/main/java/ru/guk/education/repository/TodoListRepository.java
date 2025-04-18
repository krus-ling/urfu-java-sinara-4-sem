package ru.guk.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.guk.education.entity.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
