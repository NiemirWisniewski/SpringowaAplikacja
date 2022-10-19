package pl.nw.hehexd.domain;

@javax.persistence.Entity
public class Customer extends AbstractEntity{

    private String name;
    private String surname;
    private String username;
    private String email;
    private String address;
    private Role role;

}
