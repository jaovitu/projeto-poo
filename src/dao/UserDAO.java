package dao;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (name, email, password, gender) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt;

        try {
            stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getGender());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
