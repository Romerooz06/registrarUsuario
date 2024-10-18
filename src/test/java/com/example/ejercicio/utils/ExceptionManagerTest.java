package com.example.ejercicio.utils;

import com.example.ejercicio.service.dto.ExceptionResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

class ExceptionManagerTest {

    private ExceptionManager exceptionManager;

    private static MockedStatic<LoggerFactory> mockedLoggerFactory;
    private Logger logger;

    @BeforeEach
    void setUp() {
        mockedLoggerFactory = mockStatic(LoggerFactory.class);
        logger = Mockito.mock(Logger.class);
        mockedLoggerFactory.when(() -> LoggerFactory.getLogger(ExceptionManager.class)).thenReturn(logger);
        exceptionManager = new ExceptionManager();
    }

    @Test
    void exceptionHandler_ShouldReturnBadRequest() {
        Exception exception = new Exception("Test exception message");

        ResponseEntity<ExceptionResponseDTO> responseEntity = exceptionManager.exceptionHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Test exception message", responseEntity.getBody().getMessage());
        Mockito.verify(logger).error("error - message {}", exception.getMessage());
    }
}
