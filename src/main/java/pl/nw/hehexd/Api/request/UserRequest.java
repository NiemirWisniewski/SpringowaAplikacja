package pl.nw.hehexd.Api.request;

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
    public UserRequest(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
