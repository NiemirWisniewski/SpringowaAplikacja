package pl.nw.hehexd.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;

    public User toUser(UserRequest userRequest) {
        return new User(userRequest.getUsername(), encoder.encode(userRequest.getPassword()), userRequest.getRole());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }
}