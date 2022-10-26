package pl.nw.hehexd.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemResponse {

    private Long id;
    private String name;
    private double cost;
}
