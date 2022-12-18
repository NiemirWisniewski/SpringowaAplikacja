package pl.nw.oceniarka.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nw.oceniarka.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}