package by.danilko.integration.http.controller;

import by.danilko.annotation.IT;
import by.danilko.spring.dto.CompanyReadDto;
import by.danilko.spring.dto.UserCreateEditDto;
import by.danilko.spring.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerIT {

    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("user/users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.model().attribute("users", IsCollectionWithSize.hasSize(7)));
    }

    @Test
    void findById() throws Exception {
        Long USER_ID = 2L;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/"+ USER_ID))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("user/user"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("user",
                                Matchers.hasProperty(
                                        UserReadDto.Fields.id, Matchers.is(2L)
                                )
                        )
                );
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .param(UserCreateEditDto.Fields.username, "createTestUserName")
                .param(UserCreateEditDto.Fields.birthDate, String.valueOf(LocalDate.now()))
                .param(UserCreateEditDto.Fields.firstName, "createTestFirstName")
                .param(UserCreateEditDto.Fields.lastName, "createTestLastName")
                .param(UserCreateEditDto.Fields.role, "ADMIN")
                .param(UserCreateEditDto.Fields.companyId, "2")
        )
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.redirectedUrlPattern("/users/{\\d+}"));
                .andExpectAll(MockMvcResultMatchers.status().is3xxRedirection(),
                        MockMvcResultMatchers.redirectedUrlPattern("/users/{\\d+}")
                );
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/3/update")
                .param(UserCreateEditDto.Fields.username, "updateTestUserName")
                .param(UserCreateEditDto.Fields.birthDate, String.valueOf(LocalDate.now()))
                .param(UserCreateEditDto.Fields.firstName, "updateTestFirstName")
                .param(UserCreateEditDto.Fields.lastName, "updateTestLastName")
                .param(UserCreateEditDto.Fields.role, "USER")
                .param(UserCreateEditDto.Fields.companyId, "1")
        )
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users/3"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
