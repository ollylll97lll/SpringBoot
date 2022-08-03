package com.example.DemoSpringBoot.services.serviceClasses;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.mappers.CatalogMapper;
import com.example.DemoSpringBoot.mappers.UserMapper;
import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.repositories.CatalogRepository;
import com.example.DemoSpringBoot.repositories.UserRepository;
import com.example.DemoSpringBoot.services.Impl.SeedingServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SeedingService implements SeedingServiceImpl {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String USER_SEED_PATH = "DemoSpringBoot\\src\\main\\java\\com\\example\\DemoSpringBoot\\templates\\seeds\\UserSeed.json";

    private final String CATALOG_SEED_PATH = "DemoSpringBoot\\src\\main\\java\\com\\example\\DemoSpringBoot\\templates\\seeds\\CatalogSeed.json";

    @Autowired
    CatalogRepository cRepository;

    @Autowired
    private UserRepository repository;

    @Autowired
    CatalogMapper cMapper;

    @Autowired
    private UserMapper uMapper;

    @Override
    public List<CatalogDTO> seedCatalogs() throws Exception {
        List<CatalogDTO> CatalogDTOsList = objectMapper.readValue(
                new File(CATALOG_SEED_PATH),
                new TypeReference<List<CatalogDTO>>() {
                });
        List<Catalogs> returnList = cRepository.saveAll(cMapper.DTOs2Catalogs(CatalogDTOsList));
        return cMapper.catalogs2DTOs(returnList);
    }

    @Override
    public List<UserDTO> seedUsers() throws Exception {
        List<UserDTO> UserDTOsList = objectMapper.readValue(new File(USER_SEED_PATH),
                new TypeReference<List<UserDTO>>() {
                });
        List<Users> returnList = repository.saveAll(uMapper.DTOs2Users(UserDTOsList));
        return uMapper.users2DTOs(returnList);
    }

}
