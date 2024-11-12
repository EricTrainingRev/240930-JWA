package com.revature;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
    If you want to group your tests to be executed together
    you can use the Suite class
 */
@RunWith(Suite.class)
/*
    use the SuiteClasses annotation to tell Junit what test classes
    you want grouped together. If more than one provide them inside
    an array
 */
@SuiteClasses({DAOTest.class, ServiceTest.class})
public class TestSuiteRunner {
    // This class is used as our entry point to execute the
    // dao and service tests

    /*
        A very common way of executing tests is to use the Maven
        test command: this tells Maven to execute your junit tests
        all together. If using a test runner you need to be careful
        because you will end up double-dipping in your tests: the
        test classes will execute individually, and then when the test
        runner is reached it will execute your tests again. If using a runner
        you will need to configure maven and the maven surefire plugin to tell
        maven what tests specifically you want to execute (or ignore)
     */
}
