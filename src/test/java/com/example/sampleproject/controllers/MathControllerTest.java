package com.example.sampleproject.controllers;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.generator.Fields;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RunWith(JQF.class)
public class MathControllerTest {

    @InjectMocks
    MathController mathController;

    @Mock
    ExecutorService executorService;

    @Mock
    Future future;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Fuzz
    public void test(@From(RequestInputGenerator.class) RequestInput mp) throws ExecutionException, InterruptedException {
        Mockito.when(executorService.submit(Mockito.any(Callable.class))).thenReturn(future);
        Mockito.when(future.get()).thenReturn(null);
//        mathController.add(mp);
    }
}
