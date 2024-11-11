package com.revature;

public class Service {

    private DAO dao;

    public Service(DAO dao){
        this.dao = dao;
    }

    // Business Rule: no Phil allowed in the database
    public String addNameExceptForPhil(String name){
        if("Phil".equals(name)){
            return "Phil is not allowed!";
        }
        return dao.addName(name);
    }


}
