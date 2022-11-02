package pl.nw.hehexd.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.nw.hehexd.user.UserRequest;
import pl.nw.hehexd.user.UserResponse;
import pl.nw.hehexd.user.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = "User")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    @ApiOperation("Show all")
    public ResponseEntity<List<UserResponse>> showAllCustomer(){
        List<UserResponse> userResponseList = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseList);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ApiOperation("Create customer")
    public ResponseEntity<UserResponse> createCustomer(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.saveCustomer(userRequest);
        URI uri = URI.create("/admin/" + userResponse.getId());
        return ResponseEntity.created(uri).body(userResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete item")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update item")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.update(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}