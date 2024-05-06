package com.example.demo2.dtoMapper;

import com.example.demo2.dto.CompanyRequestDto;
import com.example.demo2.dto.CompanyResponseDto;
import com.example.demo2.entity.Company;
import com.example.demo2.entity.Organization;

public class CompanyDtoMapper {


    public static Company mapToCompany(CompanyRequestDto companyRequestDto, Organization organization){
        Company company=new Company();
        company.setCompanyName(companyRequestDto.getCompanyName());
        company.setRegisterNumber(companyRequestDto.getRegisterNumber());
        company.setOrganization(organization);
        return company;
    }
    public static CompanyResponseDto mapToDto(Company company){
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setCompanyName(company.getCompanyName());
        companyResponseDto.setRegisterNumber(company.getRegisterNumber());
        companyResponseDto.setOrganizationId(company.getOrganization().getId());
        return companyResponseDto;
    }


}
