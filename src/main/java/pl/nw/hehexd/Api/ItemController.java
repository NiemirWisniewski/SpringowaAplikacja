package pl.nw.hehexd.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.nw.hehexd.Api.request.ItemRequest;
import pl.nw.hehexd.Api.response.ItemResponse;
import pl.nw.hehexd.service.ItemService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "Items")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    @ApiOperation("Show all")
    public ResponseEntity<List<ItemResponse>> getItems(){
        List<ItemResponse> itemResponseList = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponseList);
    }

    @PostMapping("/items")
    @ApiOperation("Create Item")
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest itemRequest){
        ItemResponse itemResponse = itemService.saveItem(itemRequest);
        URI uri = URI.create("/admin/" + itemResponse.getId());
        return ResponseEntity.created(uri).body(itemResponse);
    }

    @GetMapping("/items/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<ItemResponse> findItem(@PathVariable Long id){
        ItemResponse itemResponse = itemService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @DeleteMapping("/items/{id}")
    @ApiOperation("Delete item")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/items/{id}")
    @ApiOperation("Update item")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id, @RequestBody ItemRequest itemRequest){
        ItemResponse itemResponse = itemService.update(id, itemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }
}