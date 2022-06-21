package com.nomura.inventory.services;

import com.nomura.inventory.InventoryservicesApplication;
import com.nomura.inventory.model.InvResponse;
import com.nomura.inventory.model.Item;
import com.nomura.inventory.model.Status;
import com.nomura.inventory.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvServices {

    private static final Logger log = LoggerFactory.getLogger(InvServices.class);


    @Autowired
    @Qualifier("itemRepositoryImp")
    private ItemRepository itemRepository;


    public int getInvCount(){
        int count=itemRepository.count();;
        return count;
    }


    public List<Item> getAllInv(){
        List<Item> itemList=itemRepository.getAllItem();;
        return itemList;
    }


    public InvResponse saveInv(Item item) {
        InvResponse response = null;
        int id = itemRepository.save(item);
        response = new InvResponse();
        response.setStatus(Status.SUCCESS);
        response.setId(id);
        return response;
    }



}
