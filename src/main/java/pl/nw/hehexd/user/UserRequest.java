package pl.nw.hehexd.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import pl.nw.hehexd.domain.Role;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private String role;

    @JsonCreator
    public UserRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
