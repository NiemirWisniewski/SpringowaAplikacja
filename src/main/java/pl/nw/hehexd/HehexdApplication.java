package pl.nw.hehexd;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
import pl.nw.hehexd.item.Item;
import pl.nw.hehexd.item.ItemRepository;
import pl.nw.hehexd.jwt.JwtFilter;
import pl.nw.hehexd.user.User;
import pl.nw.hehexd.user.UserRepository;

import java.util.Collections;

@RequiredArgsConstructor
@SpringBootApplication
public class HehexdApplication {

	public static void main(String[] args) {
		SpringApplication.run(HehexdApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ItemRepository itemRepository, UserRepository userRepository){
	return args -> {
		itemRepository.save(new Item("Messana", 100.5));
		itemRepository.save(new Item("Berlin", 150.10));
		itemRepository.save(new Item("Roma", 200.5));

		userRepository.save(new User("elfik", "hehe" , "ADMIN"));
		userRepository.save(new User("bartek123", "hehe", "MOD"));
		userRepository.save(new User("michaubiałek", "hehe", "SUPERADMIN"));

	};	}

	@Bean
	FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/items/*"));
		return filterRegistrationBean;
	}
}