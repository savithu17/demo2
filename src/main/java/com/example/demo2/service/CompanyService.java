package com.example.demo2.service;

import com.example.demo2.dto.CompanyRequestDto;
import com.example.demo2.dto.CompanyResponseDto;
import com.example.demo2.dtoMapper.CompanyDtoMapper;
import com.example.demo2.entity.Company;
import com.example.demo2.entity.Organization;
import com.example.demo2.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CompanyService
{
    private final CompanyRepository companyRepository;
    private final OrgnaizationService orgnaizationService;

    public CompanyResponseDto createCompany (CompanyRequestDto companyRequestDto){
        log.info("CompanyService::createCompany():: started");
        Organization organization = orgnaizationService.getOrganizationEntity(companyRequestDto.getOrganizationId());
        Company company=CompanyDtoMapper.mapToCompany(companyRequestDto,organization);
        company = companyRepository.save(company);
        log.info("CompanyService::createCompany():: Completed");
        return CompanyDtoMapper.mapToDto(company);
    }
    public CompanyResponseDto updateCompany (Long companyId,CompanyRequestDto companyRequestDto){
        log.info("CompanyService::updateCompany():: started");
        Organization organization = orgnaizationService.getOrganizationEntity(companyRequestDto.getOrganizationId());
        Company company=CompanyDtoMapper.mapToCompany(companyRequestDto,organization);
        company.setId(companyId);
        company =  companyRepository.save(company);
        log.info("CompanyService::updateCompany():: Completed");
        return CompanyDtoMapper.mapToDto(company);
    }

    public Company getCompany (Long companyId) {
        log.info("CompanyService::getCompany():: started");
        Company company = companyRepository.findById(companyId).orElseThrow();
        log.info("CompanyService::getCompany():: Completed");
        return company;
    }

    public void deleteCompany(Long id) {
        log.info("CompanyService::deleteCompany():: started");
        companyRepository.deleteById(id);
        log.info("CompanyService::deleteCompany():: Completed");


    }

}
