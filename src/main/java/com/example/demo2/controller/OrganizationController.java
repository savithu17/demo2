package com.example.demo2.controller;

import com.example.demo2.dto.OrganizationRequestDto;
import com.example.demo2.dto.OrganizationResponseDto;
import com.example.demo2.entity.Organization;
import com.example.demo2.service.OrgnaizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {
    private final OrgnaizationService orgnaizationService;


    public OrganizationController(OrgnaizationService orgnaizationService) {
        this.orgnaizationService = orgnaizationService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrganizationResponseDto>creatorganization(@RequestBody OrganizationRequestDto organizationRequestDto){

        OrganizationResponseDto savedOrganization = orgnaizationService.saveOrganization(organizationRequestDto);
        return ResponseEntity.ok(savedOrganization);
    }

    @GetMapping("/getOrganizationById/{id}")
    public ResponseEntity<OrganizationResponseDto> getOrganizationById(@PathVariable Long id)
    {
        return orgnaizationService.getOrganizationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrganizationResponseDto> updateOrganization(@PathVariable Long id,@RequestBody OrganizationRequestDto organizationRequestDto){
        return orgnaizationService.updateOrganization(id,organizationRequestDto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id){
        orgnaizationService.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }


}
