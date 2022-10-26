package pl.nw.hehexd.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.nw.hehexd.domain.Role;

@Data
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String role;

}
