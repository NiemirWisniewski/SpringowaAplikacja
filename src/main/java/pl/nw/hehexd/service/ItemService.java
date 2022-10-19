package pl.nw.hehexd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.hehexd.Api.response.ItemResponse;
import pl.nw.hehexd.domain.Item;
import pl.nw.hehexd.repository.ItemRepository;
import pl.nw.hehexd.support.ItemMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemResponse> findAll() {
        List<Item> itemList = itemRepository.findAll();
        return itemList.stream()
                .map(itemMapper::toItemResponse)
                .collect(Collectors.toList());
    }
}
