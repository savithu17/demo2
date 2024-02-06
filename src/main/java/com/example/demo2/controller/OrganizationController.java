package com.example.demo2.controller;

import com.example.demo2.entity.Organization;
import com.example.demo2.service.OrgnaizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {
    private final OrgnaizationService orgnaizationService;


    public OrganizationController(OrgnaizationService orgnaizationService) {
        this.orgnaizationService = orgnaizationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Organization>creatorganization(@RequestBody Organization organization){

        Organization savedOrganization = orgnaizationService.saveOrganization(organization);
        return ResponseEntity.ok(savedOrganization);
    }

    @GetMapping("/getOrganizationById/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id)
    {
        return orgnaizationService.getOrganizationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id,@RequestBody Organization organizationDetails){
        return orgnaizationService.updateOrganization(id,organizationDetails)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id){
        orgnaizationService.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }


}
