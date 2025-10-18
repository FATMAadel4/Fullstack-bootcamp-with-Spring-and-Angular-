package main.com.myApp.controller;

import main.com.myApp.model.Employee;
import main.com.myApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "formPage";
    }

    @RequestMapping("/processform")
    public String submitForm(@Valid @ModelAttribute("employee") Employee employee,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formPage";
        }
        try {
            service.registerEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "resultPage";
    }
}
