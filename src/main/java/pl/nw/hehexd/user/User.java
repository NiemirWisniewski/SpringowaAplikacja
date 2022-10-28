package pl.nw.hehexd.user;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true)
    private String username;
    //@Column(nullable = false)
    private String password;
    //@Enumerated(EnumType.STRING)
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

/*spring.jpa.hibernate.ddl-auto=create-drop

        spring.datasource.url=jdbc:postgresql://localhost:5432/test
        spring.datasource.username=postgres
        spring.datasource.password=postgres
        spring.datasource.driver-class-name=org.postgresql.Driver
 */
