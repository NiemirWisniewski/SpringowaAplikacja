package pl.nw.oceniarka.user.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.nw.oceniarka.exception.userException.UserExceptionSupplier;
import pl.nw.oceniarka.exception.userException.UserNotFoundException;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.domain.role.Role;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldfindByUsername() {

        // given
        User user = new User("aron", "aron", Role.ADMIN, "aronwwo@gmail.com");

         userRepository.save(user);
        //when
        User user1 = userRepository.findByUsername("aron").orElseThrow(); //sprawdzenie czy nasza stworzona metoda zwraca oczekiwaną instancje encji
        boolean equals = user1.equals(user);

        //then
        assertThat(equals).isTrue();
    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void itShouldntfindByUsername() {

        // given
        User user = new User("aron", "aron", Role.ADMIN, "aronwwo@gmail.com");

        boolean equals = false;

        //when
        try {
            User user1 = userRepository.findByUsername("aron").orElseThrow(UserExceptionSupplier.userNotFound("aron"));
        }catch (UserNotFoundException exception) {
            equals = true; //sprawdza czy wywołanie naszej niezapisanej encji zwraca exception
        }
            //then
            assertThat(equals).isTrue();
        }

        @Test
        void shouldReturnTrueExistsByEmailTest(){
        //given
            User user = new User("test", "test", Role.ADMIN, "test");
        userRepository.save(user);

        //when
        boolean shouldReturnTrue = userRepository.existsByEmail(user.getEmail());

        //then
        assertThat(shouldReturnTrue).isTrue();
    }

}