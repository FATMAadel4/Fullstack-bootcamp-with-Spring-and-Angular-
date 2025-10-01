package com.vehiclesSystem.config;

import com.vehiclesSystem.config.config.Config;
import com.vehiclesSystem.config.controller.BikeController;
import com.vehiclesSystem.config.controller.CarController;
import com.vehiclesSystem.config.controller.PlaneController;
import com.vehiclesSystem.config.models.Bike;
import com.vehiclesSystem.config.models.Car;
import com.vehiclesSystem.config.models.Plane;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        CarController carController = context.getBean(CarController.class);
        PlaneController planeController = context.getBean(PlaneController.class);
        BikeController bikeController = context.getBean(BikeController.class);

        Car car = new Car();
        car.setBrand("Toyota");
        car.setType("Car");
        carController.saveVehicle(car);

        Plane plane = new Plane();
        plane.setBrand("Boeing");
        plane.setType("Plane");
        planeController.saveVehicle(plane);

        Bike bike = new Bike();
        bike.setBrand("Honda");
        bike.setType("Bike");
        bikeController.saveVehicle(bike);


        context.close();
    }
}

