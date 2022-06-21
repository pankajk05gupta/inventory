package com.nomura.inventory.controllers;


import com.nomura.inventory.model.InvResponse;
import com.nomura.inventory.model.Item;
import com.nomura.inventory.services.InvServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InvServices invServices;

    @GetMapping(value = "/item/count")
    public Integer getItemCount(){
        return invServices.getInvCount();
    }

    @GetMapping(value = "/items")
    public List<Item> getItems(){
        return invServices.getAllInv();
    }

    @PostMapping(value = "/item/add")
    public ResponseEntity<InvResponse> addInventory(@RequestBody Item item){
        System.out.println("This this test"+item);
        InvResponse invResponse=invServices.saveInv(item);
        return ResponseEntity.ok().body(invResponse);

    }

}
