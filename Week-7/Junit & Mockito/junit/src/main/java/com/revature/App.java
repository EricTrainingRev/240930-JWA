package com.revature;

public class App {

    public static void main(String[] args) {
        DAO dao = new DAO();
        Service service = new Service(dao);
        API api = new API(service);

        System.out.println(api.addNameProvidedByUser("Phil"));
    }

}
