package com.suaistuds.monitoringequipments.model.dto;
import com.suaistuds.monitoringequipments.model.entity.Reservation;
import com.suaistuds.monitoringequipments.model.entity.StatusReserv;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class ReservationDto {
    private static final String URL = "jdbc:postgresql://localhost:5432/Monitoring";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    public void put(Reservation r) {
        String insert = "INSERT INTO \"Reservation\" (equipment, \"user\", \"startTime\", \"endTime\", status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insert)) {

            stmt.setLong(1, r.getEquipment());
            stmt.setLong(2, r.getUser());
            stmt.setTimestamp(3, Timestamp.valueOf(r.getStartTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(r.getEndTime()));
            stmt.setString(5, r.getStatus().name());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении бронирования: " + e.getMessage());
        }
    }

    public List<Reservation> getAll() {
        List<Reservation> list = new ArrayList<>();
        String query = "SELECT * FROM \"Reservation\"";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setID(rs.getLong("ID"));
                r.setEquipment(rs.getLong("equipment"));
                r.setUser(rs.getLong("user"));
                r.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
                r.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
                r.setStatus(StatusReserv.valueOf(rs.getString("status")));
                list.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении бронирований: " + e.getMessage());
        }
        return list;
    }

    public void delete(Long id) {
        String query = "DELETE FROM \"Reservation\" WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении бронирования: " + e.getMessage());
        }
    }

    public void update(Reservation r) {
        String query = "UPDATE \"Reservation\" SET equipment = ?, \"user\" = ?, \"startTime\" = ?, \"endTime\" = ?, status = ? WHERE \"ID\" = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, r.getEquipment());
            stmt.setLong(2, r.getUser());
            stmt.setTimestamp(3, Timestamp.valueOf(r.getStartTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(r.getEndTime()));
            stmt.setString(5, r.getStatus().name());
            stmt.setLong(6, r.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении бронирования: " + e.getMessage());
        }
    }
}
