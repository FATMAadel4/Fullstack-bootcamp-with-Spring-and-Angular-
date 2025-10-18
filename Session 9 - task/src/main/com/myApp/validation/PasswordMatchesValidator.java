package main.com.myApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import main.com.myApp.model.Employee;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Employee> {

    @Override
    public boolean isValid(Employee emp, ConstraintValidatorContext context) {
        if (emp.getPassword() == null || emp.getConfirmPassword() == null) return false;
        return emp.getPassword().equals(emp.getConfirmPassword());
    }
}
