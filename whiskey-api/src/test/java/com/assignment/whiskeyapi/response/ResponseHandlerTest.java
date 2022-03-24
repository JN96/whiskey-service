package com.assignment.whiskeyapi.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ResponseHandlerTest {

    final Response successResponse = new Response(HttpStatus.OK.value(), "Test description.");

    @InjectMocks
    private ResponseHandler responseHandler;

    @Test
    public void shouldCreateSuccessResponse() {
        ResponseEntity responseEntity = responseHandler.handleResponse(HttpStatus.OK, "Test description.");
        assertTrue(responseEntity.hasBody());
        assertTrue(responseEntity.getBody().toString().equals(successResponse.toString()));
    }

}
