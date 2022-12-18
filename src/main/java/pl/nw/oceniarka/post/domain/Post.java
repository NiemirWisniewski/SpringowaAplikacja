package pl.nw.oceniarka.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.nw.oceniarka.comment.domain.Comment;
import pl.nw.oceniarka.post.rating.Rating;
import pl.nw.oceniarka.user.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = { CascadeType.MERGE }) //removed CascadeType.PERSIST so commandlinerunner in main class could work
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private LocalDateTime dateAdded;

    @JoinColumn(name = "ratings_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    @OneToMany(cascade = {  CascadeType.MERGE, CascadeType.REMOVE }) //removed CascadeType.PERSIST so commandlinerunner in main class could work
    private List<Comment> comment;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
        this.dateAdded = LocalDateTime.now();
        this.rating = new Rating();
    }
}
