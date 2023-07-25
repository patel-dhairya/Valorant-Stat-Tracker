// This is exception handler class

package com.gamedata.valorant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException ){
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrorModelList(), HttpStatus.BAD_REQUEST);
    }
}
