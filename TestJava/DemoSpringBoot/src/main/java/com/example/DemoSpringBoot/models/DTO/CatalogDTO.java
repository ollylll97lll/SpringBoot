package com.example.DemoSpringBoot.models.DTO;

import java.util.Date;
import java.util.List;

import com.example.DemoSpringBoot.entities.Items;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogDTO {
    private String catalogID, catalogName, description;
    private List<Items> itemsList;
    private Date createdDate, updateDate;
    private boolean isDeleted;
}
