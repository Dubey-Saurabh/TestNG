package com.testng;

import org.testng.annotations.DataProvider;

public class DataProviderOnly {

    @DataProvider(name = "input-provider")
    public Object[][] inputData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "John Doe";
        data[0][1] = "Tester@gmail.com";
        data[1][0] = "Jane Doe";
        data[1][1] = "SeniorTester@gmail.com";
        data[0][2] = "1";
        data[1][2] = "2";

        return data;
    }

}
