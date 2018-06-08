package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {

    Connection connection;

    public MySQLUsersDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }



    @Override
    public User findByUsername(String username) {
        String cadena="SELECT id,username,email,password FROM users WHERE username=? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(cadena);
            stmt.setString(1, username);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (! rs.next()) {
                return null;
            } else {
                return new User(rs.getLong("id")
                        , rs.getString("username")
                        , rs.getString("email")
                        , rs.getString("password"));
            }
        }catch (SQLException e){
            throw new RuntimeException("Error connecting to the database from finByUsername!", e);
        }

    }

    @Override
    public Long insert(User user) {
        String cadena= "INSERT INTO users (username,email, password)"+" VALUES (?,?,?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(cadena,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e){
            throw new RuntimeException("Error connecting to the database!",e);
        }
    }
}
