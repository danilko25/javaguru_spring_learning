package by.danilko.spring.service;

import by.danilko.spring.database.repository.UserRepository;
import by.danilko.spring.mapper.UserMapper;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
}
