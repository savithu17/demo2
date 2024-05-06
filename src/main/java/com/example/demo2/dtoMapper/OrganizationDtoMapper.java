package com.example.demo2.dtoMapper;

import com.example.demo2.dto.OrganizationRequestDto;
import com.example.demo2.dto.OrganizationResponseDto;
import com.example.demo2.entity.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDtoMapper {
    public static Organization mapToEntity(OrganizationRequestDto organizationRequestDto){
        Organization organization = new Organization();
        organization.setName(organizationRequestDto.getName());
        organization.setAddress(organizationRequestDto.getAddress());
        organization.setRegisterNumber(organizationRequestDto.getRegisterNumber());
        return organization;
    }

    public static OrganizationResponseDto mapToDto(Organization organization) {
        OrganizationResponseDto organizationResponseDto = new OrganizationResponseDto();
        organizationResponseDto.setId(organization.getId());
        organizationResponseDto.setName(organization.getName());
        organizationResponseDto.setAddress(organization.getAddress());
        organizationResponseDto.setRegisterNumber(organization.getRegisterNumber());
        return organizationResponseDto;
    }


    // mapToDto  -- return to Response
}
