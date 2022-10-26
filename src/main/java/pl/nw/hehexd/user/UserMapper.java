package pl.nw.hehexd.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toCustomerResponse(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }

    public User toCustomer(UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.getRole());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }
}