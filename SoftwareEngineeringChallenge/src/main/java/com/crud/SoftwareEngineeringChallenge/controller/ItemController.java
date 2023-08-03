package com.crud.SoftwareEngineeringChallenge.controller;

//local
import com.crud.SoftwareEngineeringChallenge.dto.ItemDto;
import com.crud.SoftwareEngineeringChallenge.service.ItemService;

//imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    

}
