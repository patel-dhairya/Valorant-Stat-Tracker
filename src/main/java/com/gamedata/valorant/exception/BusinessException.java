package com.gamedata.valorant.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errorModelList;
    public BusinessException(List<ErrorModel> errorModelList){
        this.errorModelList = errorModelList;
    }

}
