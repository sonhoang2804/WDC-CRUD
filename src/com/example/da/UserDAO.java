package com.example.da;

import com.example.entity.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3308/T1907m?userSSl=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USER_SQL = "INSERT INTO user" + " (name, email, country) VALUES " +
            "(?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country FROM user WHERE id=?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id=?";
    private static final String UPDATE_USERS_SQL = "UPDATE user set name = ?, email = ?, country = ? WHERE id = ?;";

    public UserDAO() {};

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        return connection;
    }

    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getCountry());
        preparedStatement.executeUpdate();
    }

    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        return user;
    }

    public List < User > selectAllUsers() throws SQLException, ClassNotFoundException {
        List < User > users = new ArrayList < > ();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
            return users;
    }
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() > 0;

            return rowDelete;
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
        statement.setString(1, user.getName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getCountry());
        statement.setInt(4, user.getId());
        rowUpdate = statement.executeUpdate() > 0;
        return rowUpdate;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (getConnection()!=null){
            System.out.println("oke");
        }
    }
}
