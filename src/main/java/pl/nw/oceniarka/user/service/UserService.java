package pl.nw.oceniarka.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.oceniarka.user.domain.User;
import pl.nw.oceniarka.user.dto.UserMapper;
import pl.nw.oceniarka.user.dto.request.UserRequest;
import pl.nw.oceniarka.user.dto.response.UserResponse;
import pl.nw.oceniarka.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface{

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user =  userMapper.toUser(userRequest);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Long id){
            return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user")));
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user"));
        userRepository.delete(user);
    }


    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user"));
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
