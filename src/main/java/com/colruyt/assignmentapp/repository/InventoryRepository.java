package com.colruyt.assignmentapp.repository;

import com.colruyt.assignmentapp.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Inventory findByProductId(Long id);
    @Query("select a,b from OrderClass b join Inventory a on b.productId=a.productId where b.orderId=?1")
    List<Inventory> findByOrderId(Long id);
}
