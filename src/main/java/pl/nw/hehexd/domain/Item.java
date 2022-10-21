package pl.nw.hehexd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends AbstractEntity{


    private Long id;
    private String name;
    private double cost;

    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}