package pl.nw.hehexd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDetailRequest")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDetail extends AbstractEntity {

    private String name;
    private String surname;
    private String address;
    private String email;
}
