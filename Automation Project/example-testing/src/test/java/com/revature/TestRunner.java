package com.revature;

import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;
import com.revature.utility.Setup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.revature.steps",
        features = "classpath:features",
        plugin = {"pretty","json:src/test/resources/json-report.json", "html:/src/test/resources/html-report.html"}
)
public class TestRunner {

    public static WebDriver driver;

    public static WebDriverWait alertWait;
    
    public static LoginPage loginPage;

    public static RegistrationPage registrationPage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
        Setup.main(new String[]{});
    }


}
