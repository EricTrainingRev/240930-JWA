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
        app.get("/authors/{id}",this::getById);
        app.post("/authors",this::create);
        app.put("/authors/{id}",this::update);
        app.delete("/authors/{id}",this::delete);
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
        int id = Integer.parseInt(
                ctx.pathParam("id")
        );
        Author a = authorService.getById(id);
        if(a != null){
            ctx.status(200);
            ctx.json(a);
        } else {
            ctx.status(404);
            ctx.result("Author not found");
        }
    }

    @Override
    public void create(Context ctx) {
        Author a = ctx.bodyAsClass(Author.class);
        Author result = authorService.create(a);
        if(result != null){
            ctx.status(201);
            ctx.json(result);
        } else {
            ctx.status(400);
            ctx.result("Could not add author");
        }
    }

    @Override
    public void update(Context ctx) {
        Author a = ctx.bodyAsClass(Author.class);
        Author result = authorService.update(a);
        if(a != null){
            ctx.status(200);
            ctx.json(a);
        } else {
            ctx.status(400);
            ctx.result("Could not update Author");
        }
    }

    @Override
    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean authorDeleted = authorService.delete(id);
        if(authorDeleted){
            ctx.status(200);
            ctx.result("Author deleted");
        } else {
            ctx.status(400);
            ctx.result("Author not deleted");
        }
    }
}
