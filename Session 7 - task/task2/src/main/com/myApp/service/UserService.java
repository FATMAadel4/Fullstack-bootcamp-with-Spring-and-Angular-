package main.com.myApp.service;

import main.com.myApp.DAO.UserDAO;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;


    public void registerUser(User user)  {
        try {

            if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
                throw new IllegalArgumentException("First Name is required");
            }

            if (user.getLastName() == null || user.getLastName().isEmpty()) {
                throw new IllegalArgumentException("Last Name is required");
            }

            if (user.getEmail() == null || user.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }

            if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new IllegalArgumentException("Invalid email format");
            }

            if (user.getDateOfBirth() == null) {
                throw new IllegalArgumentException("Date of Birth is required");
            }

            if (user.getCity() == null || user.getCity().isEmpty()) {
                throw new IllegalArgumentException("City is required");
            }
            userDAO.save(user);}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}