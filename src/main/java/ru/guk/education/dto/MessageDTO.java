package ru.guk.education.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String sender;
    private String content;
}