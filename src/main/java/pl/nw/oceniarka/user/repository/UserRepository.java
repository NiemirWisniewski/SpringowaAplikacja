package pl.nw.oceniarka.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nw.oceniarka.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
