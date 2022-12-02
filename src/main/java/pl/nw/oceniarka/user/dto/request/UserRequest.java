package pl.nw.oceniarka.user.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import pl.nw.oceniarka.user.domain.role.Role;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private Role role;
    private String email;

    @JsonCreator
    public UserRequest(String username, String password, Role role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
