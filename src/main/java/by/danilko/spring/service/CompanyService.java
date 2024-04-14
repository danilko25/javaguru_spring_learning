package by.danilko.spring.service;

import by.danilko.spring.database.repository.CompanyRepository;
import by.danilko.spring.dto.CompanyReadDto;
import by.danilko.spring.listener.AccessType;
import by.danilko.spring.listener.EntityEvent;
import by.danilko.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper companyMapper;

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id).map(company -> {
            applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
            return new CompanyReadDto(company.getId(), company.getName());
        });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyMapper::map)
                .collect(Collectors.toList());
    }
}
