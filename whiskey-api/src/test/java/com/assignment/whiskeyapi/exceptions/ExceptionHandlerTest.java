package com.assignment.whiskeyapi.exceptions;

import com.assignment.whiskeyapi.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlerTest {

    final WhiskeyServiceException whiskeyServiceExceptionResponse = new WhiskeyServiceException(HttpStatus.BAD_REQUEST.value(), "testMethod", "Test error.", "Test exception.");
    final Response errorResponse = new Response(HttpStatus.BAD_REQUEST.value(), "testMethod", "Test exception.", "Test error.");

    @InjectMocks
    private ExceptionHandler exceptionHandler;

    @Test
    public void shouldCreateWhiskeyServiceException() {
        WhiskeyServiceException whiskeyServiceException = exceptionHandler.createServiceException(HttpStatus.BAD_REQUEST, "testMethod", "Test error.", new Exception("Test exception."));
        assertEquals(whiskeyServiceException.toString(), whiskeyServiceExceptionResponse.toString());
    }

    @Test
    public void shouldCreateExceptionResponse() {
        ResponseEntity exceptionResponse = exceptionHandler.handleException(whiskeyServiceExceptionResponse);
        assertEquals(exceptionResponse.getBody().toString(), errorResponse.toString());
    }

}
