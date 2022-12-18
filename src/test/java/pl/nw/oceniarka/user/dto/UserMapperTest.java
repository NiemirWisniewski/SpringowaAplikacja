package pl.nw.oceniarka.user.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.domain.role.Role;
import pl.nw.oceniarka.user.dto.request.UserRequest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThat(user).isEqualTo(user1);


    }

    @Test
    void toUserResponse() {
    }
}