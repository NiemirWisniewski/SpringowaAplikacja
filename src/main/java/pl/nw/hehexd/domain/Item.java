package pl.nw.hehexd.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Items")
@Getter
@Setter
@NoArgsConstructor
public class Item extends AbstractEntity{

    @Column(length = 255)
    private String name;
    private double cost;

    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}