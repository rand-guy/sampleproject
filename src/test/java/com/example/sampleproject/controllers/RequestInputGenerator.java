package com.example.sampleproject.controllers;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class RequestInputGenerator extends Generator<RequestInput> {

    public RequestInputGenerator() {
        super(RequestInput.class); // Register the type of objects that we can create
    }

    @Override
    public RequestInput generate(SourceOfRandomness random, GenerationStatus __ignore__) {
        RequestInput requestInput = new RequestInput();
        if(random.nextBoolean())
            requestInput.setOne(random.nextInt());
        if(random.nextBoolean())
            requestInput.setTwo(random.nextInt());
        return requestInput;
    }

}
