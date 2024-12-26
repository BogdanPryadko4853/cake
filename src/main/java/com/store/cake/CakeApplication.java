package com.store.cake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			// Создаем роли
//			Role adminRole = new Role();
//			adminRole.setName("ADMIN");
//			roleRepository.save(adminRole);
//
//			Role userRole = new Role();
//			userRole.setName("USER");
//			roleRepository.save(userRole);
//
//			// Создаем пользователей
//			User admin = new User();
//			admin.setUsername("admin");
//			admin.setPassword(passwordEncoder.encode("admin"));
//			admin.setRoles(Set.of(adminRole));
//			userRepository.save(admin);
//
//			User user = new User();
//			user.setUsername("user");
//			user.setPassword(passwordEncoder.encode("user"));
//			user.setRoles(Set.of(userRole));
//			userRepository.save(user);
//		};
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
