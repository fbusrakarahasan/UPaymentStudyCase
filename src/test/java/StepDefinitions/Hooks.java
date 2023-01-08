package StepDefinitions;

import utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setup(){
    }

    @After
    public void teardown() {
        Driver.closeDriver();
    }

}