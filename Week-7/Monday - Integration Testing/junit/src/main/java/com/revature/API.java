package com.revature;

public class API {

    private Service service;

    public API(Service service){
        this.service = service;
    }

    public String addNameProvidedByUser(String name){
        return service.addNameExceptForPhil(name);
    }




}
