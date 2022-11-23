package com.cg.controllers.api;


import com.cg.dto.order.*;
<<<<<<< HEAD
=======
import com.cg.repositories.model.Order;
>>>>>>> development
import com.cg.repositories.model.OrderType;
import com.cg.services.impl.OrderService;

import com.cg.services.impl.UserService;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    private OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

        List<OrderPurchaseDTO> orderListPurchaseList = orderService.findAllOrderPurchase();

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
    }


    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){

        List<OrderListPurchase> orderResultList = orderService.findAllByOrderTypeCustomerList();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

//    @GetMapping("/exportsNoodle")
//    public ResponseEntity<?> getAllOrderByExportNoodle(){
//
//        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();
//
//        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
//    }

    @GetMapping("/exportsNoodle")
    public ResponseEntity<?> getAllOrderByExportNoodle(){

        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

//    @GetMapping("/exNoodle/{data}")
//    public ResponseEntity<?> getAllOrderByExport(@PathVariable Instant data){
//        List<OrderResult> orderResultList = orderService.findAllByCreatedAtAndOrderType(data, OrderType.CUSTOMER);
//        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrder(){

        List<OrderResult> orderResultList = orderService.findAll();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

    @PostMapping("/create/import")
    public ResponseEntity<?> doCreateImportOrder(@Valid @RequestBody OrderPurchase orderPurchase){

        return new ResponseEntity<>(orderService.createOrderImport(orderPurchase), HttpStatus.CREATED);

    }

    @PostMapping("/create/export")
    public ResponseEntity<?> doCreateExportOrder(){ 


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> doSearch(@PathVariable String keyword) {

        List<OrderPurchaseDTO> orderListPurchaseList = orderService.findOrderByFullNameContainsAndOrderType(keyword);

        //List<OrderPurchaseDTO>
        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.ACCEPTED);

    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {

        List<OrderResult> orderListPurchaseList = orderService.findAllByUserId(id);

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
    }

    @PatchMapping("updateStatus")
    public ResponseEntity<?> doUpdateStatus(String orderStatus){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping("/chartOneDay")
    public ResponseEntity<?> chartOneDay(){
        return new ResponseEntity<>( orderService.chartOneDay(), HttpStatus.OK);
    }

    @GetMapping("/chartSevenDay")
    public ResponseEntity<?> chartSevenDay() {
        List<OrderResultChart> chartSevenDay = orderService.findOrderSevenDay();
        return new ResponseEntity<>(chartSevenDay, HttpStatus.OK);
    }

<<<<<<< HEAD
    @GetMapping("/pending")
    public ResponseEntity<?> getOrderByStatusPending(){

        List<OrderPurchaseDTO> orderPurchaseList = orderService.findAllOrderPurchaseStatusPending();

        return new ResponseEntity<>(orderPurchaseList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/complete")
    public ResponseEntity<?> getOrderByStatusComplete(){

        List<OrderPurchaseDTO> orderPurchaseList = orderService.findAllOrderPurchaseStatusComplete();

        return new ResponseEntity<>(orderPurchaseList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/cancel")
    public ResponseEntity<?> getOrderByStatusCancel(){

        List<OrderPurchaseDTO> orderPurchaseList = orderService.findAllOrderPurchaseStatusCancel();

        return new ResponseEntity<>(orderPurchaseList, HttpStatus.ACCEPTED);
    }

=======
    @GetMapping("/chartOneMonth")
    public ResponseEntity<?> chartOneMonth() {
        List<OrderResultChart> chartSevenDay = orderService.findOrderOneMonth();
        return new ResponseEntity<>(chartSevenDay, HttpStatus.OK);
    }

    @GetMapping("/getAllOrderByRole")
    public ResponseEntity<?> getAllOrderByRole(){

        List<OrderResult> orders = orderService.getAllOrderByRole();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
>>>>>>> development

}
