// This is exception handler class

package com.gamedata.valorant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleDataValidation(MethodArgumentNotValidException mav){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = mav.getBindingResult().getFieldErrors();
        for (FieldError fieldError: fieldErrorList){
            errorModel = new ErrorModel();
            errorModel.setCode(fieldError.getField());
            errorModel.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException ){
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrorModelList(), HttpStatus.BAD_REQUEST);
    }
}
