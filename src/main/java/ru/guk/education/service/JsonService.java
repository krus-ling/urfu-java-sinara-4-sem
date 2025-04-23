package ru.guk.education.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.guk.education.model.RequestData;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class JsonService {

    public RequestData processJson(@RequestBody RequestData requestData) {
        // Проверяем, есть ли объект info, если нет — создаем новый
        if (requestData.getInfo() == null) {
            requestData.setInfo(new RequestData.Info());
        }

        // Генерируем случайный 5-значный ID (от 10000 до 99999)
        long randomId = ThreadLocalRandom.current().nextInt(10000, 100000);
        requestData.getInfo().setId(randomId);

        return requestData;
    }
}
