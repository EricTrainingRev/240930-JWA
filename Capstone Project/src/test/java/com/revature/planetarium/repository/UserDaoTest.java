package com.revature.planetarium.repository;

import com.revature.planetarium.Utility;
import com.revature.planetarium.entities.User;
import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

public class UserDaoTest {
    // set the type to the interface
    private UserDao userDao;

    private static String validGetUserUsername;
    private static User validGetUserData;
    private static String invalidGetUser;

    @BeforeClass
    public static void setupTestData(){
        validGetUserUsername = "Batman";
        validGetUserData = new User(1,"Batman","I am the night");
        invalidGetUser = "Joker";

    }

    @Before
    public void setupTestObjects(){
        Utility.main(new String[]{});
        // initialize the implementation class
        userDao = new UserDaoImp();
    }

    @Test
    public void findUserByUsernamePositiveTest(){
        /*
            Optionals are useful when you can't guarantee what data is going to be returned
            by a method. It gives you a consistent return object you can then perform validation
            on to determine what action to take, typically determined by whether your optional
            contains an object of the expected type which is indicated by a Generic declaration
         */
        Optional<User> result = userDao.findUserByUsername(validGetUserUsername);
        /*
            Once you have your results back you need to validate the results are what you expect.
            There are multiple ways you can do this, choose a way that makes sense to you and
            your team, and ideally covers as many edge cases you can think of
         */
        User user = result.get();
        Assert.assertEquals(validGetUserData, user);
    }

    @Test
    public void findUserByUsernameNegativeTest(){
        /*
            Since we expect no user data in our negative test we only need to set up a
            non-existent username for our test, pass it to the get method, and validate
            the optional returned is empty
         */
        Optional<User> result = userDao.findUserByUsername(invalidGetUser);
        Assert.assertTrue(result.isEmpty());
    }

}
