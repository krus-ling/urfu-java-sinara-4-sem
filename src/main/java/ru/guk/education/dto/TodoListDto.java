package ru.guk.education.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TodoListDto {
    public String name;
    public List<String> events;
}
