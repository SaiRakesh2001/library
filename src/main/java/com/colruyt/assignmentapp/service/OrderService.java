package com.colruyt.assignmentapp.service;

import com.colruyt.assignmentapp.exception.InvalidRequest;
import com.colruyt.assignmentapp.exception.OutOfStockException;
import com.colruyt.assignmentapp.exception.QuantityException;
import com.colruyt.assignmentapp.model.Inventory;
import com.colruyt.assignmentapp.model.OrderClass;
import com.colruyt.assignmentapp.repository.InventoryRepository;
import com.colruyt.assignmentapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    public OrderClass create(OrderClass orderClass) {
        Long id = orderClass.getProductId();
        Inventory inventory = inventoryRepository.findByProductId(id);
        orderClass.setPrice(inventory.getPrice()*orderClass.getQuantityOrdered());
        if(inventory.getQuantityAvailable()==0){
            throw new OutOfStockException("Product is out of stock");
        }
        if(orderClass.getQuantityOrdered()>3){
           throw new InvalidRequest("Quantity ordered should not be more than 3");
        }
        if(inventory.getQuantityAvailable()<orderClass.getQuantityOrdered()){
            throw new QuantityException("Quantity ordered should be less than quantity available");
        }
        List<Inventory> products=new ArrayList<>();
        products.add(inventoryRepository.findById(id).get());
        orderClass.setProducts(products);
        return orderRepository.save(orderClass);
    }

    public List<Inventory> findByOrderId(Long orderId) {
        List<Inventory> productList=new ArrayList<>();
        inventoryRepository.findByOrderId(orderId).forEach(i->productList.add(i));
        return productList;
    }
}
