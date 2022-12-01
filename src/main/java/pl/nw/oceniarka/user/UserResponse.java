package pl.nw.oceniarka.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.nw.oceniarka.user.role.Role;

@Data
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private String email;
}
