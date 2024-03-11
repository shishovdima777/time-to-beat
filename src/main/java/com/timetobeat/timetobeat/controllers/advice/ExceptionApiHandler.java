package com.timetobeat.timetobeat.controllers.advice;

import com.timetobeat.timetobeat.exceptions.RegistrationNotPerformedException;
import com.timetobeat.timetobeat.util.ErrorMessageResponse;
import com.timetobeat.timetobeat.util.RegistrationNotPerformedResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorMessageResponse> loginHandler(AuthenticationException e) {
        ErrorMessageResponse response = new ErrorMessageResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegistrationNotPerformedException.class)
    public ResponseEntity<RegistrationNotPerformedResponse> handleException(RegistrationNotPerformedException e) {
        RegistrationNotPerformedResponse response = new RegistrationNotPerformedResponse(
                e.getErrorMap(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
