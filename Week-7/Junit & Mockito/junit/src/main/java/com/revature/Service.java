package com.revature;

import com.revature.exception.PhilException;

public class Service {

    private DAO dao;

    public Service(DAO dao){
        this.dao = dao;
    }

    // Business Rule: no Phil allowed in the database
    public String addNameExceptForPhil(String name){
        if("Phil".equals(name)){
            throw new PhilException("Phil is not allowed!");
        }
        return dao.addName(name);
    }


}
