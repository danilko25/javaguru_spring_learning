package by.danilko.spring.service;

import by.danilko.spring.database.repository.CompanyRepository;
import by.danilko.spring.dto.CompanyReadDto;
import by.danilko.spring.listener.AccessType;
import by.danilko.spring.listener.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id).map(company -> {
            applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
            return new CompanyReadDto(company.getId(), company.getName());
        });
    }
}
