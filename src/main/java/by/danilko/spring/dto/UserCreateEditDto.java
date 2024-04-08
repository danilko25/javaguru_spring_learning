package by.danilko.spring.dto;

import by.danilko.spring.database.entity.Role;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstName;
    String lastName;
    Role role;
    Integer companyId;
}
