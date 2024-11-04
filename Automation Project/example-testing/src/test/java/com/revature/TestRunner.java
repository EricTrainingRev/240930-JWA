package com.revature;

import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.revature.steps",
        features = "classpath:features",
        plugin = "pretty"
)
public class TestRunner {

    public static WebDriver driver;
    
    public static LoginPage loginPage;

    public static RegistrationPage registrationPage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


}
