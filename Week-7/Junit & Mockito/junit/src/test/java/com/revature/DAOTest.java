package com.revature;

import org.junit.*;

// A common naming convention when working with Junit and creating tests for your code is to
// make your test class share the same name but start or end with "test"
public class DAOTest {

    public static String validName;
    public static String invalidName;
    public DAO dao;

    /*
        BeforeClass will execute before any tests in the class. This method is typically used to
        initialize any static resources that are meant to be shared or provide some form of consistent
        value, or is simply data that needs to exist during the execution for your tests. This method
        can also be used to handle environment setup for your tests (think updating test databases)

        Keep in mind BeforeClass is meant to be used for static methods
     */
    @BeforeClass
    public static void staticSetup(){
        System.out.println("static setup run");
        validName = "Teddy";
        invalidName = "Phil";
    }

    /*
        For many tests you will need to reset data or initialize variables before each test of your class:
        in these scenarios using a "Before" annotated method is preferable to making statically created
        resources that run the risk of being changed between test methods. It is always preferable to
        work with "fresh" resources for each test when possible, and this can be accomplished using the
        "Before" annotation
     */
    @Before
    public void preTest(){
        // Because only the dao is present for these tests, we are doing unit testing
        System.out.println("pretest method run");
        dao = new DAO();
    }

    /*
        The annotation you will most commonly use with Junit is the "Test" annotation. This tells Junit
        the method is a test case and Junit will track the execution of all "Test" annotated methods
        to determine the success/failure rate of your tests

        In Junit a test case is considered to "pass" if no unhandled exceptions are thrown. If an unhandled
        exception is thrown, no matter what it is, then Junit will mark the test as "failed" and continue on
        with other test execution
     */
    @Test
    public void addNameAddsSingleString(){
        /*
            Anytime you are testing a method you need to actually call the method in your test, but you
            also are going to want to assert that some condition is met
         */
        dao.addName("Teddy");
        /*
            When possible, try to limit your assertions to a single Assert per test case when doing
            integration and unit testing. You can do more if needed, but if you are needing multiple
            Assert statements to validate your code it may be worth considering refactoring your code
            or creating more test cases to validate the requirements you are testing
         */
        Assert.assertEquals(1, dao.databaseOfNames.size());
        Assert.assertEquals("Teddy",dao.databaseOfNames.get(0));
    }

    /*
        Any actions that need to happen between test executions can be triggered via a method annotated
        with "After". This tells Junit to execute the wrapped code after every single test case of the
        class
     */
    @After
    public void postTest(){
        System.out.println("posttest method run");
    }

    /*
        If you need to do any final tear down activity before moving on to your next test class you can
        perform those actions in a public static method annotated with AfterClass. This is useful if you
        need to reset a database, destroy or close resources, or generate documentation after testing
     */
    @AfterClass
    public static void staticTearDown(){
        System.out.println("static tear down run");
    }

}
