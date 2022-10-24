package pl.nw.hehexd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.hehexd.Api.request.UserRequest;
import pl.nw.hehexd.Api.response.UserResponse;
import pl.nw.hehexd.domain.User;
import pl.nw.hehexd.repository.UserRepository;
import pl.nw.hehexd.support.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserResponse saveCustomer(UserRequest userRequest) {
        User user =  userMapper.toCustomer(userRequest);
        userRepository.save(user);
        return userMapper.toCustomerResponse(user);
    }

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::toCustomerResponse).collect(Collectors.toList());
    }
}
