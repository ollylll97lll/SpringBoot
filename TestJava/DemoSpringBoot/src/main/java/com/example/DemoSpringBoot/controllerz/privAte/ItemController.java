package com.example.DemoSpringBoot.controllerz.privAte;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.models.DTO.requestbody.CreateItemDTO;
import com.example.DemoSpringBoot.models.DTO.requestbody.EditItemDTO;
import com.example.DemoSpringBoot.services.Impl.ItemServiceImpl;

@RestController
@Transactional
@RequestMapping("api/v1/protected/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl iService;

    @PostMapping(value = "")
    public ItemDTO createItem( @Valid @RequestBody CreateItemDTO itemDTO) throws Exception {
        return iService.createItem(itemDTO);
    }

    @PutMapping(value = "/{itemID}")
    public ItemDTO updateItem(@PathVariable String itemID, @Valid @RequestBody EditItemDTO itemDTO)
            throws Exception {
        return iService.editItem(itemID, itemDTO);
    }
}
