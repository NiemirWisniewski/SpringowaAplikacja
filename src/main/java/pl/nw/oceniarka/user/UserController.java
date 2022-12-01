package pl.nw.oceniarka.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = "User")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation("Show all users")
    public ResponseEntity<List<UserResponse>> showAllUser(){
        List<UserResponse> userResponseList = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseList);
    }

    @PostMapping
    @ApiOperation("Create user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.saveCustomer(userRequest);
        //URI uri = URI.create("/api/users/" + userResponse.getId());
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find user")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete user")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update user")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.update(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}