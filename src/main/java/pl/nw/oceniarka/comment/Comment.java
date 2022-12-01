package pl.nw.oceniarka.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.nw.oceniarka.post.Post;
import pl.nw.oceniarka.user.User;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "author_id")
    private User author;
    private String comment;
    private Double rate = 0.0;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(User author, String comment, Post post, Double rate) {
        this.author = author;
        this.comment = comment;
        this.post = post;
        this.rate = rate;
    }
}