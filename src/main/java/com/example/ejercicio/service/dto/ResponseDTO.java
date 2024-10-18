package com.example.ejercicio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {

    private UUID id;

    private LocalDateTime created;

    private LocalDateTime modified;

    private LocalDateTime last_login;

    private String token;

    private Boolean isActive;

}
