package com.example.authentication;

import com.example.authentication.model.User;
import com.example.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole("USER");
            userService.saveRole("ADMIN");
            userService.saveUser("user1","1234");
            userService.saveUser("user2","1234");
            userService.addRoletoUser("user1","USER");
            userService.addRoletoUser("user2","ADMIN");
        };
    }

}
