package com.promineotech.inventoryManagement.controller;

import com.promineotech.inventoryManagement.entity.Order;
import com.promineotech.inventoryManagement.service.OrderService;
import com.promineotech.inventoryManagement.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("customers/{id}/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody Set<Long> productIds, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.submitNewOrder(productIds, id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{orderId}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateOrder(@RequestBody Order order, @PathVariable Long orderId) {
        try{
            if (order.getStatus().equals(OrderStatus.CANCELED)) {
                return new ResponseEntity<Object>(service.cancelOrder(orderId), HttpStatus.OK);
            } else if (order.getStatus().equals(OrderStatus.DELIVERED)) {
                return new ResponseEntity<Object>(service.completeOrder(orderId), HttpStatus.OK);
            }
            return new ResponseEntity<Object>("Invalid update request.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
