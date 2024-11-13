package com.revature.mock;

import com.revature.DAO;

/*
    A Mock class is used when you need to test a class that
    uses the Mocked data as a dependency (in this case, this DAO
    mock is for unit testing the Service class). The methods of
    the Mock object are "stubbed", meaning we pre-provide return
    values to "simulate" the method being called/completed

    It used to be you would manually make your own mock objects, but
    frameworks like Mockito make it much easier to work with mocks and stubs
    in the modern time
 */
public class DAOMock extends DAO {
    @Override
    public String addName(String name) {
        return "Billy";
    }
}
