package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/*
    If you ever want to parameterize your test classes and have
    Junit inject your test data for you simply tell Junit
    you want to use the Parameterized class via a @RunWith
    annotation. This tells Junit you are using parameters and
    Junit will handle injecting them for you if you configure
    the test to do so
 */
@RunWith(Parameterized.class)
public class EvenOddTest {

    private EvenOdd evenOdd;

    /*
        To tell Junit what parameters we are using we make a method that returns a collection
        of the objects we are working with. In our case, we need a collection that can hold both
        integers and strings, so the collection will be of object arrays (all classes inherit from
        the object class, so by making an object array we can store both integers and strings in
        the same data structure.
     */
    @Parameters
    public static Collection<Object[]> inputs(){
        return Arrays.asList(
                // since we need ints and strings together, we will return a 2d Object array
                new Object[][]{
                        {10,"Even"}, //even data
                        {5,"Odd"}, //odd data
                }
        );
    }

    // make sure your parameters are public if using the Parameterized class
    @Parameter// leaving off a number indicates this is the first parameter
    public int num;
    @Parameter(1)// parameter indexing starts at 0, so saying parameter 1 actually means it is parameter 2
    public String result;

    @Before
    public void beforeTest(){
        evenOdd = new EvenOdd();
    }

    @Test
    public void evenOddTest(){
        System.out.println(num);
        System.out.println(result);
        String actual = evenOdd.determineEvenOrOdd(num);
        Assert.assertEquals(result, actual);
    }



}
