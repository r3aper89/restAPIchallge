package com.crud.SoftwareEngineeringChallenge.service;

//local
import com.crud.SoftwareEngineeringChallenge.entity.Item;
import com.crud.SoftwareEngineeringChallenge.repository.ItemRepository;
import com.crud.SoftwareEngineeringChallenge.dto.ItemDto;

//imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
