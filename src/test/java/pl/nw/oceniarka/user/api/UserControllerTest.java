package pl.nw.oceniarka.user.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.nw.oceniarka.user.domain.role.Role;
import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.dto.response.UserResponse;
import pl.nw.oceniarka.user.service.UserService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    public UserService userService;
    UserController userController;

    @BeforeEach
    void setUp(){
        userController = new UserController(userService);
    }

    @Test
    void showAllUser() {

        UserResponse userResponse = new UserResponse(1L, "test", "test", Role.USER, "test");
        List<UserResponse> response = new ArrayList<>();
        response.add(userResponse);
        //given
        given(userService.findAllUsers()).willReturn(response);
        ResponseEntity<List<UserResponse>> response1 = new ResponseEntity<>(response, HttpStatus.OK);
        //when
        ResponseEntity<List<UserResponse>> testedresponse = userController.showAllUser();
        //then
        boolean resultOfTest = testedresponse.equals(response1);
        assertTrue(resultOfTest);
    }

    @Test
    void createUser() {

        UserRequest userRequest = new UserRequest("test", "test", Role.USER, "test");
        UserResponse userResponse = new UserResponse(1L , "test", "test", Role.USER, "test");
        //given
        given(userService.saveUser(userRequest)).willReturn(userResponse);
        //when
        ResponseEntity<UserResponse> testedresponse = userController.createUser(userRequest);
        //then
        ResponseEntity<UserResponse> response1 = ResponseEntity.created(URI.create("/api/users/1")).body(userResponse);

        boolean resultOfTest = testedresponse.equals(response1);
        assertTrue(resultOfTest);
    }

    @Test
    void findUser() {

        UserResponse userResponse = new UserResponse(1L , "test", "test", Role.USER, "test");
        ResponseEntity<UserResponse> response1 = new ResponseEntity<>(userResponse, HttpStatus.OK);
        //given
        //when
        given(userService.findUserById(1L)).willReturn(userResponse);
        //then
        ResponseEntity<UserResponse> testedresponse = userController.findUser(1L);

        boolean resultOfTest = testedresponse.equals(response1);
        assertTrue(resultOfTest);
    }

    @Test
    void deleteUser() {

        UserResponse userResponse = new UserResponse(1L , "test", "test", Role.USER, "test");
        ResponseEntity<Void> response1 = new ResponseEntity<>(HttpStatus.OK);
        //given
        //when

        //then
        ResponseEntity<Void> testedresponse = userController.deleteUser(1L);

        boolean resultOfTest = testedresponse.equals(response1);
        assertTrue(resultOfTest);

    }

    @Test
    void updateUser() {

        UserResponse userResponse = new UserResponse(1L , "test", "test", Role.USER, "test");
        ResponseEntity<UserResponse> response1 = new ResponseEntity<>(userResponse, HttpStatus.OK);
        //given
        //when
        given(userService.findUserById(1L)).willReturn(userResponse);
        //then
        ResponseEntity<UserResponse> testedresponse = userController.findUser(1L);

        boolean resultOfTest = testedresponse.equals(response1);
        assertTrue(resultOfTest);

    }
}