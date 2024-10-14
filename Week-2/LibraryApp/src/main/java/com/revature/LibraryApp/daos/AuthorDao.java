package com.revature.LibraryApp.daos;

import com.revature.LibraryApp.models.Author;
import com.revature.LibraryApp.util.ConnectionFactory;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;

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
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String dateInString = rs.getString(4);
                Date date = formatter.parse(dateInString);
                Author a = new Author(
                        rs.getInt("author_id"),
                        rs.getString("name"),
                        rs.getString("biography"),
                        date
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
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "SELECT * FROM authors WHERE author_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String dateInString = rs.getString(4);
                Date date = formatter.parse(dateInString);
                return new Author(
                        rs.getInt("author_id"),
                        rs.getString("name"),
                        rs.getString("biography"),
                        date
                );            }
        } catch (SQLException | ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Author create(Author model) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "INSERT INTO authors (name, biography, birth_date) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,model.getName());
            ps.setString(2,model.getBiography());
            java.sql.Date date = new java.sql.Date(model.getBirthDate().getTime());
            ps.setDate(3,date);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                model.setAuthorId(rs.getInt(1));
                return model;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Author update(Author model) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "UPDATE authors SET name = ?, biography = ?, birth_date = ? WHERE author_id = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,model.getName());
            ps.setString(2,model.getBiography());
            java.sql.Date date = new java.sql.Date(model.getBirthDate().getTime());
            ps.setDate(3,date);
            ps.setInt(4,model.getAuthorId());
            int result = ps.executeUpdate();
            if(result == 1){
                return model;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "DELETE FROM authors WHERE author_id = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if(result == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
