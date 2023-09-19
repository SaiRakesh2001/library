package com.colruyt.assignmentapp.repository;

import com.colruyt.assignmentapp.model.Inventory;
import com.colruyt.assignmentapp.model.OrderClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<OrderClass,Long> {
}
