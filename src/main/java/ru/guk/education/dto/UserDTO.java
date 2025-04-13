package ru.guk.education.dto;

import ru.guk.education.validation.ValidName;
import ru.guk.education.validation.ValidUsername;

public class UserDTO {

    @ValidName
    private String name;

    @ValidUsername
    private String username;

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
