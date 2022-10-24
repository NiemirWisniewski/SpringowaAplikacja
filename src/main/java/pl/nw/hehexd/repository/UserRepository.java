package pl.nw.hehexd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nw.hehexd.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
