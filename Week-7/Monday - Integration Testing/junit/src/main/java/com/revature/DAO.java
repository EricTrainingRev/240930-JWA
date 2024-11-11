package com.revature;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    // this is our mock database for the example
    public List<String> databaseOfNames;

    public DAO(){
        databaseOfNames = new ArrayList<>();
    }

    public String addName(String name){
        databaseOfNames.add(name);
        return name;
    }


}
