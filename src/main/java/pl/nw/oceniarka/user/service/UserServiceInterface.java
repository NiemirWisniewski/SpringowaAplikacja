package pl.nw.oceniarka.user.service;

import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.dto.response.UserResponse;

import java.util.List;

public interface UserServiceInterface {

   UserResponse saveUser(UserRequest userRequest);

   UserResponse findUserById(Long id);

   void deleteUser(Long id);

   UserResponse updateUser(Long id, UserRequest userRequest);

   List<UserResponse> findAllUsers();
}
