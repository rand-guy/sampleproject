package com.example.sampleproject;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.example.sampleproject.controllers.MathController;
import com.example.sampleproject.controllers.RequestInput;

public class ExampleFuzzer {

    static MathController mathController;

    public static void fuzzerInitialize() {
        mathController = new MathController();
    }

    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        mathController.getter(data.consumeInt());
        mathController.add(new RequestInput(data.consumeInt(), data.consumeInt()), data.consumeString(100),
                data.consumeString(100));
    }
}
