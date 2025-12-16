package demoapp.service;

import demoapp.Repository.AuthorityRepository;
import demoapp.Repository.UserRepository;
import demoapp.model.Authority;
import demoapp.model.User;
import demoapp.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(RegistrationModel model) {


        String encodedPassword =
                passwordEncoder.encode(model.getPassword());


        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        userRepository.save(user);


        Authority authority = new Authority();
        authority.setUsername(model.getUsername());
        authority.setAuthority("ROLE_USER");

        authorityRepository.save(authority);
    }
}

