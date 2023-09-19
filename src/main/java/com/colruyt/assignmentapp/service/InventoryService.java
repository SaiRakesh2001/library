package com.colruyt.assignmentapp.service;

import com.colruyt.assignmentapp.model.Inventory;
import com.colruyt.assignmentapp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    public Inventory create(Inventory inventory) {
     return inventoryRepository.save(inventory);
    }
}
