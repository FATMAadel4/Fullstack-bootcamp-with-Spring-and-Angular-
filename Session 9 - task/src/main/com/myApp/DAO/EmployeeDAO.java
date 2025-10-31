package main.com.myApp.DAO;

import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component

public class EmployeeDAO {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;


    @Value("${db.driver-class-name}")
    private String dbDriver;
    private Connection connection;

    @PostConstruct
    public void connectToDatabase() throws SQLException {
        System.out.println("URL = " + url);
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("Driver = " + dbDriver);

        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(" Database connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void disconnectFromDatabase() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println(" Database connection closed");
        }
    }

    public void save(Employee emp) throws SQLException {
        try {


            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO employee (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getUsername());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

