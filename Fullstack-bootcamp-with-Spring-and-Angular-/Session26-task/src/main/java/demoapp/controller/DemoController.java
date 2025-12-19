package demoapp.controller;

import demoapp.model.RegistrationModel;
import demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {



        @Autowired
        private UserService userService;

        @GetMapping("/")
        public String showRegisterForm(Model model) {
            model.addAttribute("registrationModel", new RegistrationModel());
            return "register";
        }

        @PostMapping("/register")
        public String processRegister(
                @ModelAttribute RegistrationModel registrationModel) {

            userService.registerNewUser(registrationModel);
            return "redirect:/login";
        }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}





