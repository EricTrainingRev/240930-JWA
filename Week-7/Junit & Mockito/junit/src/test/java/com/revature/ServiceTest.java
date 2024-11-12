package com.revature;

import com.revature.exception.PhilException;
import org.junit.*;

public class ServiceTest {

    private static String validName;
    private static String invalidName;
    private static String invalidNameMessage;
    private DAO dao;
    private Service service;

    @BeforeClass
    public static void setup(){
        validName = "Stacey";
        invalidName = "Phil";
        invalidNameMessage = "Phil is not allowed!";
    }

    @Before
    public void pretest(){
        // Because the service and dao work together, we are doing Integration testing in this test class
        dao = new DAO();
        service = new Service(dao);
    }

    @Test
    public void addNameExceptForPhilPositiveTest(){
        String result = service.addNameExceptForPhil(validName);
        Assert.assertEquals(validName, result);
    }

    /*
        Since we are refactoring the service method to throw an exception instead of returning a
        message we need to utilize Junit's exception testing features. There are two ways you can
        do this:
        - use a try catch block
        - use Junit's assertThrows method
     */
    @Ignore("Test is redundant, leaving for the example")// if you need to ignore a test use this annotation
    @Test
    public void addNameExceptForPhilNegativeTestUsingTryCatch(){
        try{
            // we need to actually trigger the exception for our test, so we call the method being tested and pass it the invalid input
            service.addNameExceptForPhil(invalidName);
            // if no exception is thrown we need to tell Junit the test failed because we did not get the expected result
            Assert.fail("Expected PhilException to be thrown, but no exception was thrown");
        } catch (PhilException exception){
            // in the catch block we can validate the content of our exception
            Assert.assertEquals(invalidNameMessage, exception.getMessage());
        }
    }

    @Test
    public void addNameExceptForPhilNegativeTestUsingAssertThrows(){
        /*
            An alternative to try/catch is utilizing the Assert assertThrows method. This method
            checks that your method you want tested returns the expected exception. The method requires
            the use of a "ThrowableRunnable",  which just means you need to follow the code syntax below
            to tell Junit with method you are testing
         */
        PhilException exception = Assert.assertThrows(PhilException.class, ()->
                {
                    service.addNameExceptForPhil(invalidName);
                }
        );
        Assert.assertEquals(invalidNameMessage, exception.getMessage());
    }

}
