package pl.nw.hehexd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends AbstractEntity{

    private String name;
    private double cost;
}
