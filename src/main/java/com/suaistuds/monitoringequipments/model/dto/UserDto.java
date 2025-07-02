package com.suaistuds.monitoringequipments.model.dto;
import com.suaistuds.monitoringequipments.model.entity.Role;
import com.suaistuds.monitoringequipments.model.entity.User;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class UserDto {
    private static final String URL = "jdbc:postgresql://localhost:5432/Monitoring";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    public void put(User user) {
        String insert = "INSERT INTO \"User\" (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insert)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole().name());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM \"User\"";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setID(rs.getLong("ID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setRole(Role.valueOf(rs.getString("role")));
                users.add(u);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении пользователей: " + e.getMessage());
        }
        return users;
    }

    public void delete(User user) {
        String query = "DELETE FROM \"User\" WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, user.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
    }

    public void update(User user) {
        String query = "UPDATE \"User\" SET username = ?, password = ?, email = ?, role = ? WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole().name());
            stmt.setLong(5, user.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении пользователя: " + e.getMessage());
        }
    }
}
