package pl.nw.oceniarka.user.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nw.oceniarka.exception.userException.EmailIsTakenException;
import pl.nw.oceniarka.exception.userException.UserNotFoundException;
import pl.nw.oceniarka.exception.userException.UsernameIsTakenException;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.domain.role.Role;
import pl.nw.oceniarka.user.dto.UserMapper;
import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock private UserRepository userRepositoryTest;
    private UserService userServiceTest;
    @Mock
    private UserMapper userMapperTest;

    @BeforeEach
    void setUp() {
        userServiceTest = new UserService(userMapperTest, userRepositoryTest);
    }

    @Test
    void saveUser() { //sprawdzamy czy userrepository.save jest uzywane przez ansza klase userservice, zakladamy ze usermapper dziala dobrze
        //given
        User user = new User("test", "test", Role.USER, "test");
        UserRequest userRequest = new UserRequest("test", "test", Role.USER, "test");
        //when
        userServiceTest.saveUser(userRequest);   //zapisujemy encje w naszym serwisie
        //then
        verify(userRepositoryTest)
                .save(userMapperTest.toUser(userRequest)); //sprawdzamy czy nasz user userServiceTest.saveUser uzywa metody userRepositoryTest
    }

    @Test
    void findAllUser(){ //sprawdzamy czy userrepository.userFindall jest uzywane przez ansza klase userservice, zakladamy ze usermapper dziala dobrze
        //when
        userServiceTest.findAllUsers();
        //then
        verify(userRepositoryTest).findAll(); //sprawdzamy czy nasza metoda userServiceTest.findAllusers wywołuje metode userRepository.findAll
    }

    @Test
    void addUserWithUsernameTakenExceptionTest(){
        //given
        UserRequest userRequest = new UserRequest("test", "test", Role.USER,"test");

        BDDMockito.given(userRepositoryTest.existsByUsername(userRequest.getUsername()))
                .willReturn(true);
        //when
        //then
        Assertions.assertThatThrownBy(() -> userServiceTest.saveUser(userRequest))
                .isInstanceOf(UsernameIsTakenException.class)
                .hasMessageContaining(String.format("Username %s is already taken", userRequest.getUsername()));

        verify(userRepositoryTest, never()).save(any());
    }

    @Test
    void addUserWithEmailIsTakenExceptionTest(){ //sprawdzamy czy metoda saveuser wyrzuci exception gdy userrepository poda odpowiednie dane

        //given
        UserRequest userRequest = new UserRequest("test", "test", Role.USER,"test");

        BDDMockito.given(userRepositoryTest.existsByEmail(userRequest.getEmail()))
                .willReturn(true);

        //when

        //then
        Assertions.assertThatThrownBy(() -> userServiceTest.saveUser(userRequest)) //czy to wywołuje metode serwisu?
                .isInstanceOf(EmailIsTakenException.class)
                .hasMessageContaining(String.format("Email %s is already taken", userRequest.getEmail()));

        verify(userRepositoryTest, never()).save(any());
    }

    @Test
    void findUserById_Success() {
        User user = new User("test", "test", Role.USER, "test");
        //given
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.of(user));
        //when
        userServiceTest.findUserById(1L);
        //then
        verify(userRepositoryTest).findById(1L); // chcecks if this command is summoned
    }

    @Test
    void findUserById_UserNotFoundException() {

        //given
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.empty());
        //when
        Assertions.assertThatThrownBy(() -> userServiceTest.findUserById(1L))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("User with id %d not found", 1L));
        //then
        verify(userRepositoryTest, never()).findById(1L); // chcecks if this command is summoned
    }

    @Test
    void deleteUser_Success() {
        User user = new User("test", "test", Role.USER, "test");
        user.setId(1L);
        //given
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.of(user));

        //when
        userServiceTest.deleteUser(1L);
        //then
        verify(userRepositoryTest).delete(user);
    }

    @Test
    void deleteUser_WithNoUserException() {
        User user = new User("test", "test", Role.USER, "test");
        user.setId(1L);
        //given
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.empty());
        //when

        //then
        Assertions.assertThatThrownBy(() -> userServiceTest.deleteUser(1L))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("User with id %d not found", user.getId()));

        verify(userRepositoryTest).delete(user);
    }


    @Test
    void updateUserWithSucces() {

        //given
        UserRequest userRequest = new UserRequest("test", "test", Role.USER,"test");
        User user = new User("test", "test", Role.USER,"test");
        user.setId(1L);

        //when
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.of(user));
        //then
        userServiceTest.updateUser(1L, userRequest);
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        verify(userRepositoryTest)
                .save(userArgumentCaptor.capture());

        //User user = userMapperTest.toUser(userRequest);

        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);

    }

    @Test
    void updateUserWithException() {

        //given
        UserRequest userRequest = new UserRequest("test", "test", Role.USER,"test");
        User user = new User("test", "test", Role.USER,"test");
        user.setId(1L);

        //when
        BDDMockito.given(userRepositoryTest.findById(1L))
                .willReturn(Optional.empty());
        //then

        Assertions.assertThatThrownBy(() -> userServiceTest.updateUser(1L, userRequest))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("User with id %d not found", user.getId()));

        verify(userRepositoryTest, never()).save(user);
    }
}