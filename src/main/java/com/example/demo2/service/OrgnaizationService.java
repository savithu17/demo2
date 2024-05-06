package com.example.demo2.service;

import com.example.demo2.dto.OrganizationRequestDto;
import com.example.demo2.dto.OrganizationResponseDto;
import com.example.demo2.dtoMapper.OrganizationDtoMapper;
import com.example.demo2.entity.Organization;
import com.example.demo2.repository.OrganizationRepository;
import lombok.Lombok;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrgnaizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationResponseDto saveOrganization(OrganizationRequestDto organizationRequestDto){
        log.info("OrgnaizationService::saveOrganization()::started.");
        Organization organization = OrganizationDtoMapper.mapToEntity(organizationRequestDto);
        organization = organizationRepository.save(organization);
        log.info("OrgnaizationService::saveOrganization()::Ended.");
        return OrganizationDtoMapper.mapToDto(organization);
    }

    public Optional<OrganizationResponseDto> getOrganizationById(Long id) {
        log.info("OrgnaizationService::getOrganizationById()::started.");
        Optional<Organization> organizationOptional = organizationRepository.findById(id);
        log.info("OrgnaizationService::getOrganizationById()::Ended.");
        return organizationOptional.map(OrganizationDtoMapper::mapToDto);
    }

    //WRONG
    public Organization getOrganizationEntity(Long id){
        log.info("OrgnaizationService::getOrganizationEntity::started.");
       Organization organization = organizationRepository.findById(id).orElseThrow();
        log.info("OrgnaizationService::getOrganizationEntity::Ended.");
       return organization;
    }

    public List<OrganizationResponseDto> getAllOrganizations(){
        log.info("OrgnaizationService::getAllOrganizations::started.");
        List<Organization> organizationList = organizationRepository.findAll();
        log.info("OrgnaizationService::getAllOraganizations::Ended.");
        return organizationList.stream().map(OrganizationDtoMapper::mapToDto).toList();
    }

    public Optional<OrganizationResponseDto> updateOrganization(Long id,OrganizationRequestDto organizationRequestDto){
        log.info("OrgnaizationService::updateOrganization::started.");
        if(organizationRepository.existsById(id)){
            Organization organization = OrganizationDtoMapper.mapToEntity(organizationRequestDto);
            organization.setId(id);
            organization= organizationRepository.save(organization);
            log.info("OrgnaizationService::updateOraganization::Ended.");
            return Optional.of(OrganizationDtoMapper.mapToDto(organization));
        }
        return null;
    }

public void deleteOrganization(Long id){
    log.info("OrgnaizationService::deleteOrganization::started.");
    organizationRepository.deleteById(id);
    log.info("OrgnaizationService::deleteOraganizations::Ended.");
}

}
