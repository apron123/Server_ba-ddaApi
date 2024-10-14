package com.ziumks.badda.exception;

import com.ziumks.badda.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageService messageService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e, WebRequest request) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageService.get500());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageService.get404());
    }

    @ExceptionHandler(HttpConnectionException.class)
    public ResponseEntity<String> handleResourceNotFoundException(HttpConnectionException e, WebRequest request) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageService.getMessage("common.error.http"));
    }

    @ExceptionHandler(NoRowsAffectedException.class)
    public ResponseEntity<String> handleNoRowsAffectedException(NoRowsAffectedException e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        List<String> errorMessageList = new ArrayList<>();
        e.getBindingResult().getFieldErrors()
                .forEach(fieldError -> Optional.ofNullable(fieldError)
                        .ifPresent(error -> errorMessageList.add(
                                error.getField() + error.getDefaultMessage())));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessageList);
    }

}
