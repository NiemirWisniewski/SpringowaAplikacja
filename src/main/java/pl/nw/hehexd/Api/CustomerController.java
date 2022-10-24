package pl.nw.hehexd.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nw.hehexd.Api.request.UserRequest;
import pl.nw.hehexd.Api.response.UserResponse;
import pl.nw.hehexd.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "User")
@RequiredArgsConstructor
public class CustomerController {

    private final UserService userService;

    @GetMapping("/customers")
    @ApiOperation("Show all")
    public ResponseEntity<List<UserResponse>> showAllCustomer(){
        List<UserResponse> userResponseList = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseList);
    }

    @PostMapping("/customers")
    @ApiOperation("Create customer")
    public ResponseEntity<UserResponse> createCustomer(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.saveCustomer(userRequest);
        URI uri = URI.create("/admin/" + userResponse.getId());
        return ResponseEntity.created(uri).body(userResponse);
    }
}