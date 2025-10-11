package main.com.myApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import main.com.myApp.model.User;
import main.com.myApp.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.SQLException;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String showHomePage() {

        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model) {
        User user = new User();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setDateOfBirth(request.getParameter("dateOfBirth"));
        user.setCity(request.getParameter("city"));

        try {
            userService.registerUser(user);
            model.addAttribute("user", user);
            model.addAttribute("message", "Data submitted successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }


        return "resultPage";
    }
}
