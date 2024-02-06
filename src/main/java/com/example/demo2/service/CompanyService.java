package com.example.demo2.service;

import com.example.demo2.entity.Company;
import com.example.demo2.entity.Organization;
import com.example.demo2.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company saveCompany(Company company){
        return companyRepository.save(company);

    }

    public Optional<Company> getCompanyById(long id){
        return companyRepository.findById(id);
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();

    }
    public Optional<Company> updateCompany(Long id, Company companyDetails){
        return companyRepository.findById(id).map(existingCompany ->{
            existingCompany.setCompanyName(companyDetails.getCompanyName());
            existingCompany.setRegisterNumber(companyDetails.getRegisterNumber());
            return companyRepository.save(existingCompany);

        });
    }
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }



}
