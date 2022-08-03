package com.example.DemoSpringBoot.controllerz.privAte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.services.serviceClasses.SeedingService;

@RestController
@RequestMapping("api/v1/protected/seeding")
@Transactional
public class SeedingController {

    @Autowired
    private SeedingService sService;

    @PostMapping(value = "/users")
    public List<UserDTO> seedUsers() throws Exception {
        return sService.seedUsers();
    }

    @PostMapping(value = "/catalogs")
    public List<CatalogDTO> seedCatalog() throws Exception {
        return sService.seedCatalogs();
    }
}
