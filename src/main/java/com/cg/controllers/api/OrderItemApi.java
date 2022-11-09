package com.cg.controllers.api;

import com.cg.dto.order_itemDTO.OrderItemCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemApi {

    @GetMapping("")
    public ResponseEntity<?> getCartItem(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Valid @RequestBody OrderItemCreate orderItemCreate){



        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
