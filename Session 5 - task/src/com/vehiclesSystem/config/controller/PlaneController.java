package com.vehiclesSystem.config.controller;

import com.vehiclesSystem.config.dao.DatabaseOperations;
import com.vehiclesSystem.config.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PlaneController {

    private DatabaseOperations databaseOperations;

    @Autowired
    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveVehicle(Plane plane)  throws SQLException {
        databaseOperations.saveVehicle(plane);
    }
}

