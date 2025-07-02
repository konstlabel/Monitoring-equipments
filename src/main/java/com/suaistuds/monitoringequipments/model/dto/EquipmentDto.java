package com.suaistuds.monitoringequipments.model.dto;

import com.suaistuds.monitoringequipments.model.entity.Equipment;
import com.suaistuds.monitoringequipments.model.entity.Status;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class EquipmentDto {
    private static final String URL = "jdbc:postgresql://localhost:5432/Monitoring";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    public void put(Equipment equipment) {
        String insert = "INSERT INTO \"Equipment\" (name, \"serialNumber\", status,type) VALUES (?, ?, ?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insert)) {

            stmt.setString(1, equipment.getName());
            stmt.setString(2, equipment.getSerialNumber());
            stmt.setString(3, equipment.getStatus().name());
            stmt.setString(4,equipment.getType());// если Status — enum

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Оборудование успешно добавлено!");
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при вставке данных: " + e.getMessage());
        }
    }
    public List<Equipment> getEquipments() {
        List<Equipment> equipments = new ArrayList<>();
        String query = "SELECT * FROM \"Equipment\"";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setID(rs.getLong("ID"));
                equipment.setName(rs.getString("name"));
                equipment.setSerialNumber(rs.getString("serialNumber"));
                String statusStr = rs.getString("status");
                equipment.setStatus(Status.valueOf(statusStr));
                equipments.add(equipment);
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при получении данных: " + e.getMessage());
        }
        return equipments;
    }
    public void delete(Equipment equipment) {
        String query = "DELETE FROM \"Equipment\" WHERE \"ID\" = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, equipment.getID());

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Оборудование успешно удалено.");
            } else {
                System.out.println("Оборудование не найдено для удаления.");
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при удалении оборудования: " + e.getMessage());
        }
    }
    public void update(Equipment equipment) {
        String query = "UPDATE \"Equipment\" SET name = ?, \"serialNumber\" = ?, status = ?, type = ? WHERE \"ID\" = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, equipment.getName());
            stmt.setString(2, equipment.getSerialNumber());
            stmt.setString(3, equipment.getStatus().name());
            stmt.setString(4, equipment.getType());
            stmt.setLong(5, equipment.getID());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Оборудование успешно обновлено.");
            } else {
                System.out.println("Оборудование с указанным ID не найдено.");
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении оборудования: " + e.getMessage());
        }
    }
}
