// This is exception handler class

package com.gamedata.valorant.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleDataValidation(MethodArgumentNotValidException mav){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = mav.getBindingResult().getFieldErrors();
        for (FieldError fieldError: fieldErrorList){
            logger.debug("Inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            logger.info("Inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fieldError.getField());
            errorModel.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException ){
        for (ErrorModel errorModel: businessException.getErrorModelList()) {
            logger.debug("Business Exception : {} - {}", errorModel.getCode(), errorModel.getMessage());
            logger.info("Business Exception: {} - {}", errorModel.getCode(), errorModel.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrorModelList(), HttpStatus.BAD_REQUEST);
    }
}
