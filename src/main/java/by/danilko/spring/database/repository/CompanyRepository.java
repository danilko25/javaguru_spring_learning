package by.danilko.spring.database.repository;

import by.danilko.spring.database.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {

    public Optional<Company> findById(Integer id){
        return Optional.of(new Company(id));
    }
}
