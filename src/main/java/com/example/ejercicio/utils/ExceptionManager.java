package com.example.ejercicio.utils;

import com.example.ejercicio.service.dto.ExceptionResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);

    @ExceptionHandler(value = {Exception.class})
    public @ResponseBody ResponseEntity<ExceptionResponseDTO> exceptionHandler(Exception bre) {
        logger.error("error - message {}", bre.getMessage());
        ExceptionResponseDTO er = new ExceptionResponseDTO( bre.getMessage());
        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }
}
