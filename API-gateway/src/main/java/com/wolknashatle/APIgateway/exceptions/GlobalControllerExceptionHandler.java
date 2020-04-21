package com.wolknashatle.APIgateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponce constraintViolationException(ConstraintViolationException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("errorCode", "404");
        map.put("errorMessage", "NOT FOUND");
        return new ApiErrorResponce("Error", ex.toString(), map, new String[]{"101", "data collection service is not available"} );
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponce noHandlerFoundException(Exception ex) {
        Map<String, String> map = new HashMap<>();
        map.put("errorCode", "400");
        map.put("errorMessage", "BAD REQUEST");
        return new ApiErrorResponce("Error", ex.toString(), map, new String[]{"errorCode", "errorMessage"} );
    }


}
