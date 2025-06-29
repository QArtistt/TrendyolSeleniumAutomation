package com.trendyol.step_definitions;


import com.trendyol.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook {

    @Before
    public void setup(){
        System.out.println("#####################");
        System.out.println("Test setup!");
    }
    @After
    public void teardown(Scenario scenario){

        if(scenario.isFailed()){
            System.out.println("Test failed!");
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","Test failed!");


        }else{
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        System.out.println("##############################");

        Driver.closeDriver();

    }
}