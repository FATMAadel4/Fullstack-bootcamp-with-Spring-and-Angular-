package main.com.myApp.DAO;

import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component

public class UserDAO {

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

    public void save(User user) throws SQLException {
        try {

            String sql = "INSERT INTO users (first_name, last_name, email, date_of_birth, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setDate(4, Date.valueOf(user.getDateOfBirth()));
            ps.setString(5, user.getCity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

