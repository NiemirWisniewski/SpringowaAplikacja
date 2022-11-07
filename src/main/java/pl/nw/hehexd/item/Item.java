package pl.nw.hehexd.item;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Items")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(length = 255)
    private String name;
    private double cost;

    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}