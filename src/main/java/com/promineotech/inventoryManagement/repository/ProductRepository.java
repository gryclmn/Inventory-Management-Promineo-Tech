package com.promineotech.inventoryManagement.repository;

import com.promineotech.inventoryManagement.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}
