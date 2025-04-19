package ru.guk.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guk.education.dto.TodoListDto;
import ru.guk.education.service.TodoListService;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoListController {

    private final TodoListService todoListService;

    @PostMapping
    public ResponseEntity<String> saveTodoList(@RequestBody TodoListDto dto) {
        todoListService.saveTodoList(dto);
        return ResponseEntity.ok().body("Saved");
    }

    @GetMapping
    public ResponseEntity<List<TodoListDto>> getAllTodoLists() {
        return ResponseEntity.ok(todoListService.getAllTodoLists());
    }
}
