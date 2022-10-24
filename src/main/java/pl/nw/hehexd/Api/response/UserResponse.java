package pl.nw.hehexd.Api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.nw.hehexd.domain.Role;

@Data
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private Role role;

}
