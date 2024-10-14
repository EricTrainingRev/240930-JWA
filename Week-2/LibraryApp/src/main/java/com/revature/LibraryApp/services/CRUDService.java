package com.revature.LibraryApp.services;

import java.util.List;

public interface CRUDService<M> {
    List<M> getAll();
    M getById(int id);
    M create(M model);
    M update(M model);
    boolean delete(int id);
}
