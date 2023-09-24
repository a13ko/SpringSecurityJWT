package com.ali.securityjwtproject;

import com.ali.securityjwtproject.entity.User;
import com.ali.securityjwtproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityJwtProjectApplication {
	private final UserRepository userRepository;

	@PostConstruct
	public void createUsers(){
		List<User> users = Stream.of(
				new User(1L,"Ali","{noop}ali123","ali@gmail.com"),
				new User(2L,"Elizamin","{noop}elizamin","elizamin@gmail.com"),
				new User(3L,"Turqay","{noop}password","turqay@gmail.com"),
				new User(4L,"Test","{noop}sifre123","test@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtProjectApplication.class, args);
	}

}
