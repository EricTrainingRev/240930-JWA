package com.revature.LibraryApp.daos;

import java.util.List;

/*
    We can use a generic and this interface to create the architecture for our DAO objects
    and their shared methods
*/
public interface CRUDDao<M> {
    List<M> findAll();
    M findById(int id);
    M create(M model);
    M update(M model);
    boolean delete(int id);
}
