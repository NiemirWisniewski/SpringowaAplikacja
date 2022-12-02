package pl.nw.oceniarka.user.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.dto.response.UserResponse;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;

    public User toUser(UserRequest userRequest) {
        return new User(userRequest.getUsername(), encoder.encode(userRequest.getPassword()), userRequest.getRole(), userRequest.getEmail());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
    }
}