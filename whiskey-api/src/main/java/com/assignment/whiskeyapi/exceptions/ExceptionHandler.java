package com.assignment.whiskeyapi.exceptions;

import com.assignment.whiskeyapi.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    /**
     * Builds a WhiskeyServiceException.
     * @param httpCode - the http code
     * @param method - the method where the error was raised
     * @param description - the description of the error
     * @param error - the error message
     * @return WhiskeyServiceException
     */
    public WhiskeyServiceException createServiceException(final HttpStatus httpCode, final String method, final String description, final Exception error) {
        return new WhiskeyServiceException.WhiskeyServiceExceptionBuilder()
                .httpCode(httpCode.value()).method(method)
                .description(description)
                .error(error.getMessage())
                .build();
    }

    /**
     * Handles the WhiskeyServiceException so its details can be used in a ResponseEntity and returned to the client.
     * @param whiskeyServiceException - WhiskeyServiceException
     * @return ResponseEntity
     */
    public ResponseEntity handleException(final WhiskeyServiceException whiskeyServiceException) {
        final Response whiskeyServiceExceptionResponse = new Response(whiskeyServiceException.getHttpCode(),
                whiskeyServiceException.getMethod(),
                whiskeyServiceException.getDescription(),
                whiskeyServiceException.getError());
        return ResponseEntity.status(whiskeyServiceException.getHttpCode()).body(whiskeyServiceExceptionResponse);
    }

}
