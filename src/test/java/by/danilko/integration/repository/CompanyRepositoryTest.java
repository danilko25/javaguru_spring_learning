package by.danilko.integration.repository;

import by.danilko.annotation.IT;
import by.danilko.spring.database.entity.Company;
import by.danilko.spring.database.repository.CompanyRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class CompanyRepositoryTest {


    private static final Integer APPLE_ID = 9;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries(){
        var company = companyRepository.findByName("Apple");
        var companies = companyRepository.findAllByNameContainingIgnoreCase("a");
        assertThat(companies).hasSize(7);
    }

    @Test
    void delete(){
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }

    @Test
    void findById(){
        var company = entityManager.find(Company.class,  1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save(){
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "uk", "Apple опис",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}
