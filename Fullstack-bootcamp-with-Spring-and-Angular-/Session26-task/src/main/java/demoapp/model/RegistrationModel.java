package demoapp.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class  RegistrationModel
{
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String email;
}
