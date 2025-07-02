package com.suaistuds.monitoringequipments.model.dto;
import com.suaistuds.monitoringequipments.model.entity.History;
import com.suaistuds.monitoringequipments.model.entity.Status;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class HistoryDto {
    private static final String URL = "jdbc:postgresql://localhost:5432/Monitoring";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    public void put(History history) {
        String insert = "INSERT INTO \"StatusHistory\" (equipment, \"user\", responsible, status, timestamp) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insert)) {

            stmt.setLong(1, history.getEquipment());
            stmt.setLong(2, history.getUser());
            stmt.setLong(3, history.getResponsible());
            stmt.setString(4, history.getStatus().name());
            stmt.setTimestamp(5, Timestamp.valueOf(history.getDate()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении истории: " + e.getMessage());
        }
    }

    public List<History> getAll() {
        List<History> histories = new ArrayList<>();
        String query = "SELECT * FROM \"StatusHistory\"";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                History h = new History();
                h.setID(rs.getLong("ID"));
                h.setEquipment(rs.getLong("equipment"));
                h.setUser(rs.getLong("user"));
                h.setResponsible(rs.getLong("responsible"));
                h.setStatus(Status.valueOf(rs.getString("status")));
                h.setDate(rs.getTimestamp("timestamp").toLocalDateTime());
                histories.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении истории: " + e.getMessage());
        }
        return histories;
    }

    public void delete(Long id) {
        String query = "DELETE FROM \"StatusHistory\" WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении истории: " + e.getMessage());
        }
    }

    public void update(History history) {
        String query = "UPDATE \"StatusHistory\" SET equipment = ?, \"user\" = ?, responsible = ?, status = ?, timestamp = ? WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, history.getEquipment());
            stmt.setLong(2, history.getUser());
            stmt.setLong(3, history.getResponsible());
            stmt.setString(4, history.getStatus().name());
            stmt.setTimestamp(5, Timestamp.valueOf(history.getDate()));
            stmt.setLong(6, history.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении истории: " + e.getMessage());
        }
    }
}
