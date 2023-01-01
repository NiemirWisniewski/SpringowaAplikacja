package pl.nw.oceniarka.user.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.domain.role.Role;
import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.dto.response.UserResponse;

class UserMapperTest {


    private UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    void setUp(){
        userMapper = new UserMapper(passwordEncoder);
    }


    @Test
    void toUser() {
        //given
        User user = new User("test", passwordEncoder.encode("test"), Role.USER, "test");
        UserRequest userRequest = new UserRequest("test", "test", Role.USER, "test");
        //when
        User user1 = userMapper.toUser(userRequest);
        user.equals(user1);
    }

    @Test
    void toUserResponse() {
        //given
        User user = new User("test", passwordEncoder.encode("test"), Role.USER, "test");
        user.setId(1L);
        UserResponse userResponse = new UserResponse(1L, "test", "test", Role.USER, "test");
        //when
        UserResponse userResponse1 = userMapper.toUserResponse(user);
        //then
        userResponse.equals(userResponse1);



    }
}