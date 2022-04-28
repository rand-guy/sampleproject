package com.example.sampleproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MathService {

    @Autowired
    AdditionService additionService;

    public AdditionResponse getSum(RequestInput input) {
        return additionService.getSum(input);
    }
}
