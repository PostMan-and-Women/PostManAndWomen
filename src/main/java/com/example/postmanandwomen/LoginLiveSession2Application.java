package com.example.postmanandwomen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaAuditing
@SpringBootApplication
public class LoginLiveSession2Application {

    public static void main(String[] args) {
        SpringApplication.run(LoginLiveSession2Application.class, args);
    }

}
