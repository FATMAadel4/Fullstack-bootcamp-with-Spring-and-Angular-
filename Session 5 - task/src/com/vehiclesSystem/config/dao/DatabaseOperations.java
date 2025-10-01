
package com.vehiclesSystem.config.dao;

import com.vehiclesSystem.config.models.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseOperations {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private Connection connection;

   // @PostConstruct
   // public void connectToDatabase() package com.vehiclesSystem.dao;

        @PostConstruct
        public void connectToDatabase() throws SQLException {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");
        }

        @PreDestroy
        public void disconnectFromDatabase() throws SQLException {
            if (connection != null) {
                connection.close();
                System.out.println(" Database connection closed");
            }
        }

        public void saveVehicle(Vehicle vehicle) throws SQLException {
            String query = "INSERT INTO vehicles (brand, type) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getType());
            stmt.executeUpdate();
            System.out.println(" Vehicle saved: " + vehicle);
        }

        public void deleteVehicle(int id) throws SQLException {
            String query = "DELETE FROM vehicles WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Vehicle deleted with id: " + id);
        }

        public void updateVehicle(Vehicle vehicle) throws SQLException {
            String query = "UPDATE vehicles SET brand = ?, type = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getType());
            stmt.setInt(3, vehicle.getId());
            stmt.executeUpdate();
            System.out.println(" Vehicle updated: " + vehicle);
        }

        public Vehicle searchById(int id) throws SQLException {
            String query = "SELECT * FROM vehicles WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setBrand(rs.getString("brand"));
                v.setType(rs.getString("type"));
                return v;
            }
            return null;
        }

        public List<Vehicle> getAllVehicles() throws SQLException {
            String query = "SELECT * FROM vehicles";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<Vehicle> vehicles = new ArrayList<>();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setBrand(rs.getString("brand"));
                v.setType(rs.getString("type"));
                vehicles.add(v);
            }
            return vehicles;
        }
    }
