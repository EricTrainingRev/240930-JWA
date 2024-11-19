package com.revature.planetarium.repository.user;

import java.util.Optional;

import com.revature.planetarium.entities.User;

public interface UserDao {

    /*
        Testing for createUser:
        - associated requirements
            - usernames should be unique
            - usernames should be no more than 30 characters
            - passwords should be no more than 30 characters

        This tells us createUser should have at least 4 test cases:
        - 1 positive test
        - 3 negative tests (requirements above enforced), sql exceptions should be triggered by some of these tests
     */
    Optional<User> createUser(User newUser);
    /*
        Testing for findUserByUsername:
        - there are no associated requirements with this method, a simple positive and negative
          test is appripriate here

        This tells us findUserByUsername should have at least 2 test case:
        - 1 positive test if the user exists
        - 1 negative test if no user is found
     */
    Optional<User> findUserByUsername(String username);
}
