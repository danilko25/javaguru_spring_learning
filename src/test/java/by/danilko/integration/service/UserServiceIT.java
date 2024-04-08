package by.danilko.integration.service;

import by.danilko.annotation.IT;
import by.danilko.spring.database.entity.Role;
import by.danilko.spring.dto.UserCreateEditDto;
import by.danilko.spring.dto.UserReadDto;
import by.danilko.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final static Long USER_1 = 1L;
    private static final Integer COMPANY_1 = 1;
    private final UserService userService;
    @Test
    void findAll(){
        List<UserReadDto> users = userService.findAll();
        assertThat(users).hasSize(7);
    }

    @Test
    void  findById(){
        var result = userService.findById(USER_1);
        assertTrue(result.isPresent());
        result.ifPresent(user -> assertEquals(USER_1, user.getId()));
        result.ifPresent(user -> assertEquals("john.doe", user.getUsername()));
    }

    @Test
    void create(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "testUserName",
                LocalDate.now(),
                "testFirstName",
                "TestLastName",
                Role.ADMIN,
                COMPANY_1
        );
        UserReadDto actualResult = userService.create(userDto);

        assertEquals(userDto.getUsername(), actualResult.getUsername());
        assertEquals(userDto.getBirthDate(), actualResult.getBirthDate());
        assertEquals(userDto.getFirstName(), actualResult.getFirstName());
        assertEquals(userDto.getLastName(), actualResult.getLastName());
        assertSame(userDto.getRole(), actualResult.getRole());
        assertEquals(userDto.getCompanyId(), actualResult.getCompany().id());
    }

    @Test
    void update(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "updateTestUserName",
                LocalDate.now(),
                "updateFirstName",
                "updateLastName",
                Role.USER,
                COMPANY_1
        );

        var actualResult = userService.update(USER_1, userDto);

        assertTrue(actualResult.isPresent());

        actualResult.ifPresent(user ->{
            assertEquals(userDto.getUsername(), user.getUsername());
            assertEquals(userDto.getBirthDate(), user.getBirthDate());
            assertEquals(userDto.getFirstName(), user.getFirstName());
            assertEquals(userDto.getLastName(), user.getLastName());
            assertSame(userDto.getRole(), user.getRole());
            assertEquals(userDto.getCompanyId(), user.getCompany().id());
        });
    }

    @Test
    void delete(){
        assertFalse(userService.delete(-90L));
        assertTrue(userService.delete(3L));

    }
}
