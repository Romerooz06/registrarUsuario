package com.example.ejercicio;

import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import com.example.ejercicio.service.dto.phone.PhoneDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class DataProvider {

    public static UserDTO userMock(){
        PhoneDTO phoneMock = new PhoneDTO("222","22","2");

        return new UserDTO("pepito", "pepito@gmail.com","aaAA2#bb", phoneMock);
    }

    public static ResponseDTO responseMock(){
        return new ResponseDTO(UUID.randomUUID(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyOTIxMjY5NiwiaWF0IjoxNzI5MTgzODk2LCJyb2wiOnsiYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9fQ.h8VMjE19ELs4shshayAYU93YyR1W5BWzrW32KRp7KWE",
                true);

    }
}
