package pl.nw.hehexd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nw.hehexd.domain.Customer;

public interface repository extends JpaRepository<Customer, Long> {
}
