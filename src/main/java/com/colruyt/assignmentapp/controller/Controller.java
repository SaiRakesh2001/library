package com.colruyt.assignmentapp.controller;

import com.colruyt.assignmentapp.model.Inventory;
import com.colruyt.assignmentapp.model.OrderClass;
import com.colruyt.assignmentapp.repository.InventoryRepository;
import com.colruyt.assignmentapp.repository.OrderRepository;
import com.colruyt.assignmentapp.service.InventoryService;
import com.colruyt.assignmentapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class Controller {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    OrderService orderService;

    @PostMapping("inventory/create")
    public Inventory create(@RequestBody Inventory inventory){
        return inventoryService.create(inventory);
    }
    @PostMapping("order/create")
    public OrderClass create(@RequestBody OrderClass orderClass){
        return orderService.create(orderClass);
    }
    @GetMapping("products/{orderId}")
    public List<Inventory> findByOrderId(@PathVariable Long orderId){
        return orderService.findByOrderId(orderId);
    }
}
