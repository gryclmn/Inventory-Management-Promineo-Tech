package com.promineotech.inventoryManagement.repository;

import com.promineotech.inventoryManagement.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
