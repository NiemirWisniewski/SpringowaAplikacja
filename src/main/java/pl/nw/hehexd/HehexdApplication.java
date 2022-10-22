package pl.nw.hehexd;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.nw.hehexd.domain.Customer;
import pl.nw.hehexd.domain.Item;
import pl.nw.hehexd.domain.Role;
import pl.nw.hehexd.repository.CustomerRepository;
import pl.nw.hehexd.repository.ItemRepository;
import pl.nw.hehexd.service.ItemService;

@RequiredArgsConstructor
@SpringBootApplication
public class HehexdApplication {

	private final ItemRepository itemRepository;
	private final CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(HehexdApplication.class, args);
	}

	@EventListener
	public void MakeUp(ApplicationReadyEvent event){
		itemRepository.save(new Item("Messana", 100.5));
		itemRepository.save(new Item("Berlin", 150.10));
		itemRepository.save(new Item("Roma", 200.5));

		customerRepository.save(new Customer("elfik", Role.ADMIN));
		customerRepository.save(new Customer("bartek123", Role.CUSTOMER));
		customerRepository.save(new Customer("michaubiałek", Role.SUPERADMIN));
	}
}