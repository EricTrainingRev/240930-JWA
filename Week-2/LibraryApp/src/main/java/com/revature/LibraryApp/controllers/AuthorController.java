package com.revature.LibraryApp.controllers;

import com.revature.LibraryApp.models.Author;
import com.revature.LibraryApp.services.AuthorService;
import com.revature.LibraryApp.services.CRUDService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class AuthorController implements CRUDController{

    private CRUDService<Author> authorService;

    public AuthorController(CRUDService<Author> authorService) {
        this.authorService = authorService;
    }

    @Override
    public void registerPaths(Javalin app) {
        app.get("/authors",this::getAll);
    }

    @Override
    public void getAll(Context ctx) {
        List<Author> authors = authorService.getAll();
        // TODO: need to handle null type
        if(authors != null){
            if(authors.isEmpty()){
                ctx.status(404);
                ctx.result("No Authors found");
            } else {
                ctx.status(200);
                ctx.json(authors);
            }
        }
    }

    @Override
    public void getById(Context ctx) {

    }

    @Override
    public void create(Context ctx) {

    }

    @Override
    public void update(Context ctx) {

    }

    @Override
    public void delete(Context ctx) {

    }
}
