package com.example.DemoSpringBoot.services.Impl;

import java.util.List;

import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.models.DTO.requestbody.CreateItemDTO;
import com.example.DemoSpringBoot.models.DTO.requestbody.EditItemDTO;

public interface ItemServiceImpl {
    ItemDTO getItem(String itemID) throws Exception;
    List<ItemDTO> getAllItems(String catalogID) throws Exception;

    ItemDTO createItem(CreateItemDTO itemDTO) throws Exception;
    ItemDTO editItem(String itemID, EditItemDTO editItemDTO) throws Exception;

}
