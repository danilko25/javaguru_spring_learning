package by.danilko.spring.database.repository;

import by.danilko.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c join fetch c.locales c1 where c.name = :name")
    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
