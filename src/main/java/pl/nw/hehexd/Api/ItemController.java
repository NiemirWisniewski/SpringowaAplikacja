package pl.nw.hehexd.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nw.hehexd.Api.request.ItemRequest;
import pl.nw.hehexd.Api.response.ItemResponse;
import pl.nw.hehexd.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "Items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    @ApiOperation("Show all")
    public ResponseEntity<List<ItemResponse>> getItems(){
        List<ItemResponse> itemResponseList = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponseList);
    }

}
