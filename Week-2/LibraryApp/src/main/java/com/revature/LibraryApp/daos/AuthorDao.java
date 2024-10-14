package com.revature.LibraryApp.daos;

import com.revature.LibraryApp.models.Author;
import com.revature.LibraryApp.util.ConnectionFactory;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao implements CRUDDao<Author>{
    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            Statement s = connection.createStatement();
            s.execute("SELECT * from authors");
            ResultSet rs = s.getResultSet();
            while (rs.next()){
                //TODO: need to make date information more human readable
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Author a = new Author(
                        rs.getInt("author_id"),
                        rs.getString("name"),
                        rs.getString("biography"),
                        new Date(formatter.parse(rs.getString("birth_date")).getTime())
                );
                authors.add(a);
            }
            return authors;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Author findById(int id) {

        return null;
    }

    @Override
    public Author create(Author model) {

        return model;
    }

    @Override
    public Author update(Author model) {
        return model;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
