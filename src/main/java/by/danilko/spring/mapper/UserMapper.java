package by.danilko.spring.mapper;

import by.danilko.spring.dto.UserDTO;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserMapper {

    private final UserDTO userDTO;

    public UserMapper(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
