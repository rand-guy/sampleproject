package com.example.sampleproject.controllers;

import com.example.sampleproject.SampleprojectApplication;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

//@RunWith(SpringRunner.class)
@RunWith(JQF.class)
@SpringBootTest
@ContextConfiguration(classes = {SampleprojectApplication.class})
//@TestPropertySource(locations = "classpath:application.properties")
public class MathControllerSpringTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    MathController mathController;

//    @MockBean
//    AdditionService additionService;
//
//    @Before
//    public void setup() {
//        AdditionResponse additionResponse = new AdditionResponse();
//        additionResponse.sum = 11;
//        Mockito.when(additionService.getSum(Mockito.any())).thenReturn(additionResponse);
//    }

    @Fuzz
    public void testAdd(int a, int b) {
        AdditionResponse abc = mathController.add(new RequestInput(a, b), "", "");
        System.out.println("Came here");
        System.out.println("Inputs: a=" + a + " b=" + b );
        Assert.assertEquals(a+b, abc.sum.intValue());
    }

}
