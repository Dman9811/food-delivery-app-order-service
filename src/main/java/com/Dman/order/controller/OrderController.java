package com.Dman.order.controller;

import com.Dman.order.dto.OrderDTO;
import com.Dman.order.dto.OrderDTOFromFE;
import com.Dman.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSavedInDb = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.OK);
    }
}
