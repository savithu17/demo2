package com.example.demo2.controller;

import com.example.demo2.dto.CompanyRequestDto;
import com.example.demo2.dto.CompanyResponseDto;
import com.example.demo2.entity.Company;
import com.example.demo2.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping ("/create")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        return ResponseEntity.ok(companyService.createCompany(companyRequestDto));
    }

//    @GetMapping("/getCompanyById/{id}")
//    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
//        return companyService.getCompanyById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/getAll")
//    public List<Company> getAllCompanies() {
//        return companyService.getAllCompany();
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
//        return companyService.updateCompany(id, companyDetails)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/`delete/{id}`")
//    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
//        companyService.deleteCompany(id);
//        return ResponseEntity.ok().build();
//    }
}
