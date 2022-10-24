package pl.nw.hehexd.support;

import org.springframework.stereotype.Component;
import pl.nw.hehexd.Api.request.UserRequest;
import pl.nw.hehexd.Api.response.UserResponse;
import pl.nw.hehexd.domain.User;

@Component
public class UserMapper {

    public UserResponse toCustomerResponse(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }

    public User toCustomer(UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getRole());
    }
}