package com.assignment.whiskeyapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResponseHandler {

    /**
     * Handles the appropriate response to be returned to the client.
     * @param httpCode - the http code
     * @param description - a brief description with details
     * @return ResponseEntity
     */
    public ResponseEntity handleResponse(final HttpStatus httpCode, final String description) {
        final Response response = new Response(httpCode.value(), description);
        return ResponseEntity.status(httpCode).body(response);
    }

}
