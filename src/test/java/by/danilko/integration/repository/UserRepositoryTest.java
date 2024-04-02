package by.danilko.integration.repository;

import by.danilko.annotation.IT;
import by.danilko.spring.database.entity.Role;
import by.danilko.spring.database.repository.UserRepository;
import by.danilko.spring.dto.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkPageable(){
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        //var users = userRepository.findAllBy(pageable);
        //var slice = userRepository.findAllBy(pageable);
        var page = userRepository.findAllBy(pageable);
        page.forEach(u-> System.out.println(u.getId()));
        while(page.hasNext()){
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(u-> System.out.println(u.getId()));
            System.out.println(page.getTotalPages());
        }
    }

    @Test
    void findFirst3By(){
        var users = userRepository.findFirst3By(Sort.by("firstname")
                                    .and(Sort.by("firstname"))
                                    .descending());
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void findFirstByCompanyIsNotNullOrderByIdTest(){
        var user = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();
        assertTrue(user.isPresent());
        user.ifPresent(u->assertEquals("Kim", u.getFirstname()));
    }

    @Test
    void findFirst3ByCompanyIsNotNullOrderByIdTest(){
        var users = userRepository.findFirst3ByCompanyIsNotNullOrderByIdDesc();
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void checkProjections(){
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(1);
    }

    @Test
    void checkFirstAndLastNameQuery(){
        var users = userRepository.findAllByFirstnameContainingAndLastnameContaining("n", "o");
        assertThat(users).hasSize(2);
    }

    @Test
    void checkRoleUpdateQuery(){
        var user = userRepository.findById(1L);
        assertEquals(Role.USER, user.get().getRole());
        int updated = userRepository.updateRole(Role.ADMIN, 1L,7L);
        assertTrue(updated==2);
        var updatedUser = userRepository.findById(1L);
        assertEquals(Role.ADMIN, updatedUser.get().getRole());
    }
}
