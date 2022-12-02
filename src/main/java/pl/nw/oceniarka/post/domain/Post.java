package pl.nw.oceniarka.post.domain;

import lombok.*;
import pl.nw.oceniarka.comment.domain.Comment;
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

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private LocalDateTime dateAdded;
    private Double value;
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Comment> comment;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
        this.dateAdded = LocalDateTime.now();
        this.value = 0.0;
    }

    public Post(User user, String content, Double value) {
        this.user = user;
        this.content = content;
        this.dateAdded = LocalDateTime.now();
        this.value = 0.0;
    }
}
