package pl.nw.hehexd.Api.response;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import pl.nw.hehexd.domain.Role;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String role;

}
