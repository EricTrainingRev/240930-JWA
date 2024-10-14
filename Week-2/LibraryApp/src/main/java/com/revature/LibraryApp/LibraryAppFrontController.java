package com.revature.LibraryApp;


import com.revature.LibraryApp.controllers.AuthorController;
import com.revature.LibraryApp.controllers.MemberController;
import com.revature.LibraryApp.daos.AuthorDao;
import com.revature.LibraryApp.daos.CRUDDao;
import com.revature.LibraryApp.daos.MemberDao;
import com.revature.LibraryApp.models.Author;
import com.revature.LibraryApp.models.Member;
import com.revature.LibraryApp.services.AuthorService;
import com.revature.LibraryApp.services.CRUDService;
import com.revature.LibraryApp.services.MemberService;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

import java.util.List;

public class LibraryAppFrontController {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
                    config.jsonMapper(new JavalinJackson());
                })
                .get("/", ctx -> ctx.result("Welcome to the Local Library App"));

        // Create all of our necessary classes to interact with the Member features for our API
        // DI - Dependency Injection -  required objects that should be available to the class at instantiation, necessary for feature functionality
        MemberDao memberDao = new MemberDao();
        MemberService memberService = new MemberService(memberDao);
        MemberController memberController = new MemberController(memberService);
        memberController.registerPaths(app);
        CRUDDao<Author> authorDao = new AuthorDao();
        CRUDService<Author> authorService = new AuthorService(authorDao);
        AuthorController authorController = new AuthorController(authorService);
        authorController.registerPaths(app);

        // The last step in our FrontController is to start the server
        app.start(8080);
    }
}