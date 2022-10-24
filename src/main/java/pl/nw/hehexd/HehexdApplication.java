package pl.nw.hehexd;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.nw.hehexd.domain.User;
import pl.nw.hehexd.domain.Item;
import pl.nw.hehexd.domain.Role;
import pl.nw.hehexd.repository.UserRepository;
import pl.nw.hehexd.repository.ItemRepository;

@RequiredArgsConstructor
@SpringBootApplication
public class HehexdApplication {

	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(HehexdApplication.class, args);
	}


	@EventListener
	public void MakeUp(ApplicationReadyEvent event){
		itemRepository.save(new Item("Messana", 100.5));
		itemRepository.save(new Item("Berlin", 150.10));
		itemRepository.save(new Item("Roma", 200.5));

		userRepository.save(new User("elfik", Role.ADMIN));
		userRepository.save(new User("bartek123", Role.CUSTOMER));
		userRepository.save(new User("michaubiałek", Role.SUPERADMIN));
	}
}