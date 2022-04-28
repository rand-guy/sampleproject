package com.example.sampleproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @Autowired
    MathService mathService;

//    @Autowired
//    ExecutorService executorService;

//    public MathController(ExecutorService executorService) {
//        this.executorService = executorService;
//    }

//    @Operation(summary = "Addition with Post and request body")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the book",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = AdditionResponse.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "Book not found",
//                    content = @Content),
//            @ApiResponse(responseCode = "500", description = "Internal Error") })
    @PostMapping("/addition/{id}")
    public AdditionResponse add( @RequestBody RequestInput mp, @PathVariable("id") String id,
                                 @RequestParam("requestParam") String requestParam) {
        return mathService.getSum(mp);
    }

    @GetMapping("/addition")
    public int getter(int abc) {
        int[] x = new int[10000];
        for(int i=0;i<10000;i++) x[i]=i;
        if(abc == 98271625) throw new IllegalArgumentException("It actually caught that");
        return x[abc];
    }




}
