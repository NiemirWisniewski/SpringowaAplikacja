package pl.nw.hehexd.Api.response;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import pl.nw.hehexd.domain.Role;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String username;
    private Role role;

}
