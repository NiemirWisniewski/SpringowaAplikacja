package pl.nw.oceniarka.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import pl.nw.oceniarka.user.role.Role;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private Role role;

    @JsonCreator
    public UserRequest(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
