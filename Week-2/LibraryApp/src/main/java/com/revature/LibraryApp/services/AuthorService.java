package com.revature.LibraryApp.services;

import com.revature.LibraryApp.daos.AuthorDao;
import com.revature.LibraryApp.daos.CRUDDao;
import com.revature.LibraryApp.models.Author;

import java.util.List;

public class AuthorService implements CRUDService<Author> {

    /*
        This setup would be useful if we needed to have different implementations
        of our DAO, such as having an SQLite version and a Postgres version. Setting the
        type to the interface allows us to interchange them as needed
     */
    private CRUDDao<Author> authorDao;

    public AuthorService(CRUDDao authorDao){
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public Author getById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public Author create(Author model) {
        return authorDao.create(model);
    }

    @Override
    public Author update(Author model) {
        return authorDao.update(model);
    }

    @Override
    public boolean delete(int id) {
        return authorDao.delete(id);
    }
}
