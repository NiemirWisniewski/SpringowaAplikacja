package pl.nw.hehexd.Api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDetailResponse extends AbstractResponse{

    public CustomerDetailResponse(Long id, String name, String surname, String address, String email) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    private String name;
    private String surname;
    private String address;
    private String email;
}
