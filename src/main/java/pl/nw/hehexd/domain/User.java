package pl.nw.hehexd.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends AbstractEntity{

    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
}
