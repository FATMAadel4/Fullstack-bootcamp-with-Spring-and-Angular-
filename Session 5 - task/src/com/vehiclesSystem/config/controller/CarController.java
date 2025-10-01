package com.vehiclesSystem.config.controller;

import com.vehiclesSystem.config.dao.DatabaseOperations;
import com.vehiclesSystem.config.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CarController {

    private final DatabaseOperations databaseOperations;

    @Autowired
    public CarController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveVehicle(Car car)  throws SQLException {
        databaseOperations.saveVehicle(car);
    }
}
