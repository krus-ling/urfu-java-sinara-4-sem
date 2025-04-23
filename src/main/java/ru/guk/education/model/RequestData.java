package ru.guk.education.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestData {

    private double price;
    private Info info;

    @Setter
    @Getter
    public static class Info {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Long id;
        private String date;
    }
}
