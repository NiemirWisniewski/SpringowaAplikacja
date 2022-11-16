package pl.nw.oceniarka;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.nw.oceniarka.user.role.Role;
import pl.nw.oceniarka.user.User;
import pl.nw.oceniarka.user.UserRepository;

@RequiredArgsConstructor
@SpringBootApplication
public class HehexdApplication {

	public static void main(String[] args) {
		SpringApplication.run(HehexdApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder encoder){
	return args -> {
		userRepository.save(new User("user", encoder.encode("user") , Role.USER));
		userRepository.save(new User("mod", encoder.encode("mod"), Role.MOD));
		userRepository.save(new User("admin", encoder.encode("admin"), Role.ADMIN));
	};	}
}