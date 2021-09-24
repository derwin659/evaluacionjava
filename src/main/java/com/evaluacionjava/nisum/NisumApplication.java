
package com.evaluacionjava.nisum;

import entity.Phone;
import entity.User;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import repository.PhoneRepository;
import repository.UserRepository;
import service.UserService;

@SpringBootApplication
@EnableCaching
public class NisumApplication implements CommandLineRunner {
	private UserRepository userRepository;
	private PhoneRepository phoneRepository;
	private UserService userService;

	public NisumApplication(UserRepository userRepository, UserService userService, PhoneRepository phoneRepository) {
		this.userRepository = userRepository;
		this.userService = userService;
		this.phoneRepository = phoneRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NisumApplication.class, args);
	}

	public void run(String... args) {

	}


}

