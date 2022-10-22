package pl.nw.hehexd.Api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import pl.nw.hehexd.domain.Role;

@Getter
@Setter
public class CustomerRequest {

    private String username;
    private Role role;

    @JsonCreator
    public CustomerRequest(String username, Role role) {
        this.username = username;
        this.role = role;
    }
}
