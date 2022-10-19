package pl.nw.hehexd.support;

import org.springframework.stereotype.Component;
import pl.nw.hehexd.Api.response.ItemResponse;
import pl.nw.hehexd.domain.Item;

@Component
public class ItemMapper {

    public ItemResponse toItemResponse(Item item){
        return new ItemResponse(item.getId(), item.getName(), item.getCost());
    }

}
