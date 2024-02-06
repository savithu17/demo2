package com.example.demo2.service;

import com.example.demo2.entity.Organization;
import com.example.demo2.repository.OrganizationRepository;
import lombok.Lombok;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrgnaizationService {

    private final OrganizationRepository organizationRepository;

    public Organization saveOrganization(Organization organization){
        return organizationRepository.save(organization);

    }
    public Optional <Organization> getOrganizationById(Long id){
        return organizationRepository.findById(id);
    }
    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }

    public Optional<Organization> updateOrganization(Long id,Organization organizationDetails){
        return organizationRepository.findById(id).map(existingOrganization ->{
            existingOrganization.setName(organizationDetails.getName());
            existingOrganization.setAddress(organizationDetails.getAddress());
            existingOrganization.setRegisterNumber(organizationDetails.getRegisterNumber());
            return organizationRepository.save(existingOrganization);

        });
    }

public void deleteOrganization(Long id){
        organizationRepository.deleteById(id);
}

}
