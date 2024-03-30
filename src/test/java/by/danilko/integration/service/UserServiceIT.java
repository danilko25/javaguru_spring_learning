package by.danilko.integration.service;

import by.danilko.annotation.IT;
import by.danilko.spring.database.repository.CompanyRepository;
import by.danilko.spring.database.repository.pool.ConnectionPool;
import by.danilko.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;

    @Test
    void test(){

    }
}
