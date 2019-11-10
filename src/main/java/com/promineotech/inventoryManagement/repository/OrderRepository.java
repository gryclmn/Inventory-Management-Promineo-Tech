package com.promineotech.inventoryManagement.repository;

import com.promineotech.inventoryManagement.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {}
