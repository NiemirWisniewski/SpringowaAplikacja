package pl.nw.hehexd.Api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemResponse {

    private Long id;
    private String name;
    private double cost;
}
