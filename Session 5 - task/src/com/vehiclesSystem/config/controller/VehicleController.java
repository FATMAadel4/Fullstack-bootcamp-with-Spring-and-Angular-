package com.vehiclesSystem.config.controller;

import com.vehiclesSystem.config.dao.DatabaseOperations;
import com.vehiclesSystem.config.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class VehicleController {

    private final DatabaseOperations databaseOperations;

    @Autowired
    public VehicleController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveVehicle(Vehicle vehicle)  throws SQLException {
        databaseOperations.saveVehicle(vehicle);
    }
}
