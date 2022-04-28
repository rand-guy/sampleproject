package com.example.sampleproject.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {

//    @Value("${custom.value}")
//    private String customValue;

    public AdditionResponse getSum(RequestInput input) {
        AdditionResponse additionResponse = new AdditionResponse();
        additionResponse.sum = input.getOne() + input.getTwo();
        return additionResponse;
    }

}
