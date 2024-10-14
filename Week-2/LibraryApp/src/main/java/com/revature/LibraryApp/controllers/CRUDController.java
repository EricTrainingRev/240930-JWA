package com.revature.LibraryApp.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;

public interface CRUDController {
    void registerPaths(Javalin app);
    void getAll(Context ctx);
    void getById(Context ctx);
    void create(Context ctx);
    void update(Context ctx);
    void delete(Context ctx);
}
