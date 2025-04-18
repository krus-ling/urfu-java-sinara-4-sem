package ru.guk.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.guk.education.dto.TodoListDto;
import ru.guk.education.entity.Event;
import ru.guk.education.entity.TodoList;
import ru.guk.education.repository.TodoListRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public void saveTodoList(TodoListDto dto) {
        TodoList todoList = new TodoList();
        todoList.setName(dto.getName());

        Set<Event> events = dto
                .getEvents()
                .stream()
                .map(eventTitle -> new Event(todoList, eventTitle))
                .collect(Collectors.toSet());

        todoList.setEvents(events);
        todoListRepository.save(todoList);
    }

    public List<TodoListDto> getAllTodoLists() {
        return todoListRepository
                .findAll()
                .stream()
                .map(todo -> {
                    TodoListDto dto = new TodoListDto();
                    dto.setName(todo.getName());
                    dto.setEvents(todo
                            .getEvents()
                            .stream()
                            .map(Event::getTitle)
                            .collect(Collectors.toList()));
                    return dto;
                }).collect(Collectors.toList());
    }
}
