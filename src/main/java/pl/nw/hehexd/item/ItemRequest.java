package pl.nw.hehexd.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {

    private String name;
    private double cost;

    @JsonCreator
    public ItemRequest(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
