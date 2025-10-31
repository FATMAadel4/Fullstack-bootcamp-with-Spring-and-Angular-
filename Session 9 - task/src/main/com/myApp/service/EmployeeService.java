package main.com.myApp.service;

import main.com.myApp.DAO.EmployeeDAO;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;


    public void registerEmployee(Employee emp)  {
        try {

            employeeDAO.save(emp);}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}