package pl.nw.hehexd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nw.hehexd.domain.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
