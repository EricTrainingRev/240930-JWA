package com.revature.LibraryApp.daos;

import com.revature.LibraryApp.models.Member;
import com.revature.LibraryApp.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {


    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM members";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberId(resultSet.getInt("member_id"));
                member.setName(resultSet.getString("name"));
                member.setEmail(resultSet.getString("email"));
                member.setPassword(resultSet.getString("password"));
                members.add(member);
            }

            return members;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Member create(Member member) {
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            // Create a new record in our database

            // NOTE : using Statement interface DOES NOT sanitize the input to prevent SQL injection
//            Statement statement = connection.createStatement();
//            String sql = "INSERT INTO members (name, email, password) VALUES ('" + member.getName() + "', '"
//                    + member.getEmail() + "', '" + member.getPassword() + "')";
//
//            statement.executeUpdate(sql);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO members (name, password, email) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            // Values in our SQL statement are still parameterized
            // for SQL the parameters are 1-indexed
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getEmail());
            // All of the values have been set in their parameterized positions

            int checkInsert = preparedStatement.executeUpdate();
            if (checkInsert <= 0) {
                throw new RuntimeException("Inserting member failed");
            }
            preparedStatement.getGeneratedKeys().next(); // move from column header to the first row
            member.setMemberId(preparedStatement.getGeneratedKeys().getInt(1)); // get value for the first column (CANNOT use table column name)

            return member;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public Member update(Member member) {
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE members SET name = ?, password = ?, email = ? where member_id = ?"
            );
            // Values in our SQL statement are still parameterized
            // for SQL the parameters are 1-indexed
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setInt(4, member.getMemberId());
            // All of the values have been set in their parameterized positions

            int checkInsert = preparedStatement.executeUpdate();
            if (checkInsert <= 0) {
                throw new RuntimeException("Updating member failed");
            }

            return member;
        } catch(Exception e){
            e.printStackTrace();

            return null;
        }
}


    public boolean delete(int memberId) {
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM members WHERE member_id = ?"
            );
            preparedStatement.setInt(1, memberId);

            int checkInsert = preparedStatement.executeUpdate();
            if (checkInsert <= 0) {
                throw new RuntimeException("Deleting member failed");
            }

            return true;
        } catch(Exception e){
            e.printStackTrace();

            return false;
        }
    }
}
