package com.cg.controllers.api;


import com.cg.dto.payment.PaymentCustomerResult;
import com.cg.services.IPaymentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/paymentCustomer")
public class PaymentCustomerApi {

    @Autowired
    private IPaymentCustomerService paymentCustomerService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        List<PaymentCustomerResult> paymentCustomerResults = paymentCustomerService.findAll();
        return new ResponseEntity<>(paymentCustomerResults, HttpStatus.OK);
    }
}
