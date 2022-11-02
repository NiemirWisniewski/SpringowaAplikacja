package pl.nw.hehexd.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nw.hehexd.item.ItemRequest;
import pl.nw.hehexd.item.ItemResponse;
import pl.nw.hehexd.item.ItemService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@Api(tags = "Items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    @ApiOperation("Show all")
    public ResponseEntity<List<ItemResponse>> getItems(){
        List<ItemResponse> itemResponseList = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponseList);
    }

    @PostMapping()
    @ApiOperation("Create Item")
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest itemRequest){
        ItemResponse itemResponse = itemService.saveItem(itemRequest);
        URI uri = URI.create("/admin/" + itemResponse.getId());
        return ResponseEntity.created(uri).body(itemResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<ItemResponse> findItem(@PathVariable Long id){
        ItemResponse itemResponse = itemService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete item")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update item")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id, @RequestBody ItemRequest itemRequest){
        ItemResponse itemResponse = itemService.update(id, itemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }
}