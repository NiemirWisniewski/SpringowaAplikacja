package pl.nw.hehexd.item;

import org.springframework.stereotype.Component;
import pl.nw.hehexd.item.ItemRequest;
import pl.nw.hehexd.item.ItemResponse;
import pl.nw.hehexd.item.Item;

@Component
public class ItemMapper {

    public ItemResponse toItemResponse(Item item){
        return new ItemResponse(item.getId(), item.getName(), item.getCost());
    }

    public Item toItem(ItemRequest itemRequest) {
        return new Item(itemRequest.getName(), itemRequest.getCost());
    }
}
