package pl.nw.oceniarka.post.rating;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private Double rating;
    private Double amountOfRatings;

    public Rating() {
        this.rating = 0.0;
        this.amountOfRatings = 0.0;
    }


}

