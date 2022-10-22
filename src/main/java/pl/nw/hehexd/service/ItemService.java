package pl.nw.hehexd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.hehexd.Api.request.ItemRequest;
import pl.nw.hehexd.Api.response.ItemResponse;
import pl.nw.hehexd.domain.Item;
import pl.nw.hehexd.repository.ItemRepository;
import pl.nw.hehexd.support.ItemMapper;
import pl.nw.hehexd.support.exception.ItemExceptionSupplier;

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

    public ItemResponse findById(Long id) {
        return itemMapper.toItemResponse(itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id)));
    }

    public ItemResponse saveItem(ItemRequest itemRequest) {
        Item item = itemRepository.save(itemMapper.toItem(itemRequest));
        return itemMapper.toItemResponse(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id));
        itemRepository.delete(item);
    }

    public ItemResponse update(Long id, ItemRequest itemRequest) {
        Item item = itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id));
        item.setName(itemRequest.getName());
        item.setCost(itemRequest.getCost());
        itemRepository.save(item);
        return itemMapper.toItemResponse(item);
    }
}
