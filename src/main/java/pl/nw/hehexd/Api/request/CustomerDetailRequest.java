package pl.nw.hehexd.Api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetailRequest extends AbstractRequest{

    private String name;
    private String surname;
    private String address;
    private String email;

    @JsonCreator
    public CustomerDetailRequest(String name, String surname, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }
}
