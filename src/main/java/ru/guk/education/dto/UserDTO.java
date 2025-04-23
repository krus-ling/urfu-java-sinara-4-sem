package ru.guk.education.dto;

import lombok.Getter;
import lombok.Setter;
import ru.guk.education.validation.ValidName;
import ru.guk.education.validation.ValidUsername;

@Setter
@Getter
public class UserDTO {

    @ValidName
    private String name;

    @ValidUsername
    private String username;
}
