package pl.nw.oceniarka.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserResponse saveCustomer(UserRequest userRequest) {
        User user =  userMapper.toUser(userRequest);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    public UserResponse findById(Long id){
            return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user")));
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user"));
        userRepository.delete(user);
    }


    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a user"));
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
