package com.vehiclesSystem.config.controller;

import com.vehiclesSystem.config.dao.DatabaseOperations;
import com.vehiclesSystem.config.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class BikeController {

    @Autowired
    private DatabaseOperations databaseOperations;

    public void saveVehicle(Bike bike) throws SQLException {
        databaseOperations.saveVehicle(bike);
    }
}
