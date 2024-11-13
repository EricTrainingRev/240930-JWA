package com.revature;

import com.revature.exception.PhilException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/*
    In the ServiceTest class we are performing Integration testing on the Service class. This is fine, but
    it is also a good idea to perform Unit testing on our classes. For true unit testing to happen, the classes
    need to be tested without relying on their dependencies working correctly as well. A common practice
    for achieving unit tests is by using Mock objects and stubbing their method results
    - Mock: a object used expressly for testing, usually for unit tests
    - Stub: a method with a hard-coded/pre-determined return value used for testing, usually with Mock objects
 */
public class ServiceMockTest {

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
        /*
            Since we want to do Unit testing in this class we need to mock our DAO class. We can either
            make a Mock class to use for our test or we can use Mockito to dynamically create our mock
            and stub method calls

            The Mockito class method "mock" takes in the class data of the object we want to mock and returns
            an object that has the same properties as the Mocked class (in our case the mock object will have
            the same method as the real class) but no implementation/code associated with the properties. We
            can dynamically, during each test, change the results of a method call to meet our needs
         */
        dao = Mockito.mock(DAO.class);
        service = new Service(dao);
    }

    @Test
    public void addNameExceptForPhilPositiveTest(){
        /*
            Before we actually execute the method being tested with the mock data we have to tell Mockito
            what to do with our mock object. Best practice is to try and simulate what a real use-case would
            look like with the method. This means providing reasonable test data and return reasonable responses
            - .when() is used to indicate what method in the mock object will be called and what arguments will be provided
            - .thenReturn() is used to indicate what value to return
         */
        Mockito.when(dao.addName(validName)).thenReturn(validName);
        String result = service.addNameExceptForPhil(validName);
        Assert.assertEquals(validName, result);
    }

    @Test
    public void addNameExceptForPhilNegativeTestExceptionThrown(){
        /*
            For the negative test, since the PhilException should be thrown before the dao is reached
            we don't need to worry about stubbing any results. If the exception is not thrown the
            Assert class will throw an exception and fail the test, so the mock object is not actually
            necessary for this test
         */
        PhilException exception = Assert.assertThrows(PhilException.class, ()-> {service.addNameExceptForPhil(invalidName);});
        Assert.assertEquals(invalidNameMessage, exception.getMessage());
    }

    @Test
    public void checkDaoMethodCalledOnce(){
        /*
            If you are not concerned about a specific argument being provided you can use Mockito's
            "any" methods to indicate any argument will suffice. Here we specify any String value
            is fine for our test, since we are not concerned about the functionality but with the
            number of method invocations
         */
        Mockito.when(dao.addName(Mockito.anyString())).thenReturn("Some response");
        service.addNameExceptForPhil(validName);
        Mockito.verify(dao).addName(Mockito.anyString()); // this is similar to making a check that the dao method and argument was called once
    }

    /*
        ######## MOCK EXAMPLE USE CASES BELOW ########
     */

    @Test
    public void canMockAnything(){
        /*
            You really want to try and simulate a "real world" example with your mocks because
            if you don't you can end up having tests pass (like this one) when they should not.
            Knowing how the DAO class is implemented, "Clark Kent" should be the returned value,
            but since we told Mockito to return Superman we will get an unexpected result from our
            method.
         */
        Mockito.when(dao.addName("Clark Kent")).thenReturn("Superman");
        String result = service.addNameExceptForPhil("Clark Kent");
        Assert.assertEquals("Superman", result);
    }

    @Test
    public void mockExceptions(){
        Mockito.when(dao.addName("Phil in a trench coat")).thenThrow(new PhilException("I see you Phil!"));
        Assert.assertThrows(PhilException.class, ()-> {service.addNameExceptForPhil("Phil in a trench coat");});
    }

    /*
        If you need to test auxiliary pieces of your code, such as making sure that functions are called
        that don't have a direct effect on the final output of your code (logging functions, tracking functions,
        functions that affect other data in the app, etc.) you can use Mockito, if it is mocking those objects, to
        check that they are in deed being called as expected
        - times = checks a method was called X number of times
        - atLeast = checks a method was called at least X number of times
        - atMost = checks a method was called at most X number of times

        This part of why it is good practice to create new mock objects for each individual test: your mocks
        keep track of things like times a method was executed and what to do when a method is called
        given some argument, and if you don't keep track of these things you can get unexpected results
        in your tests
     */

    @Test
    public void checkDaoMethodCalledTwice(){
        Mockito.when(dao.addName(Mockito.anyString())).thenReturn("Some response");
        service.addNameExceptForPhil(validName);
        // can swap times with atLeast and/or atMost to change the check logic
        Mockito.verify(dao, Mockito.times(2)).addName(Mockito.anyString());
    }

}
