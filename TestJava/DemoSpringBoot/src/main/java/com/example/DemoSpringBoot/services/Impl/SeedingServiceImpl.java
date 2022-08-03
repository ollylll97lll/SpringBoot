package com.example.DemoSpringBoot.services.Impl;

import java.util.List;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.models.DTO.UserDTO;

public interface SeedingServiceImpl {
    List<CatalogDTO> seedCatalogs() throws Exception;
    List<UserDTO> seedUsers() throws Exception;
}
