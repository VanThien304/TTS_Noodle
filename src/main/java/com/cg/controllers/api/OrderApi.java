package com.cg.controllers.api;


import com.cg.dto.order.*;

import com.cg.dto.payment.PaymentCustomerResult;
import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.dto.payment.PaymentResult;
import com.cg.repositories.model.*;


  import com.cg.services.impl.*;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
 import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    private PaymentPurchaseService paymentPurchaseService;
    @Autowired
    private PaymentCustomerService paymentCustomerService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

        List<OrderPurchaseDTO> orderListPurchaseList = orderService.findAllOrderPurchase();

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
    }


    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){

        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }



    @GetMapping("/exportsNoodle")
    public ResponseEntity<?> getAllOrderByExportNoodle(){

        List<OrderResultDTOS> orderResultList = orderService.findAllByOrderView();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

    @GetMapping("/exportsNoodle/{id}")
    public ResponseEntity<?> getOrderExportNoodleById(@PathVariable Long id){

        OrderResultDTOS orderResultList = orderService.findAllByOrderViewById(id);

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

    @GetMapping("/exportsNoodlePaid/{id}")
    public ResponseEntity<?> getOrderByIdPaidCustomer(@PathVariable Long id){

        OrderResultPaidDTO orderResultPaidDTO = orderService.findOrderByIdPaidCustomer(id);

        return new ResponseEntity<>(orderResultPaidDTO, HttpStatus.OK);
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

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchCustomer/{keyword}")
    public ResponseEntity<?> doSearchCustomer(@PathVariable String keyword) {

        List<OrderResultDTO> orderResultDTOS = orderService.findOrderByFullNameAndAddressContainsAndOrderType(keyword);


        return new ResponseEntity<>(orderResultDTOS, HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createExportCustomer(@Valid @RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.CREATED);
    }


    @PostMapping("/debtDeduction")
    public ResponseEntity<?> debtDeductionCustomer(Long id) {
        return null;
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {

        OrderResult orderResult = orderService.findById(id);

        return new ResponseEntity<>(orderResult, HttpStatus.OK);

    }

    @PatchMapping("/updateStatus")
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


    @GetMapping("/statusCompleted")
    public ResponseEntity<?> getStatusCompleted() {
        List<OrderResultDTOS> orderResultDTOS = orderService.findAllOrderStatusCompleted();
        return new ResponseEntity<>(orderResultDTOS, HttpStatus.OK);
    }

//    @PostMapping("/changeStatus/{id}")
//    public ResponseEntity<?> changeStatusOrderPending(@PathVariable Long id) {
//        Optional<OrderResultDTO> orderResultDTOS = .f();
//        orderResultDTOS.
//        List<OrderResultDTO> orderResultDTOS = orderService.f();
//        return new ResponseEntity<>(chartSevenDay, HttpStatus.OK);
//    }

    @GetMapping("/statusPending")
    public ResponseEntity<?> getStatusPendingCustomer() {
        List<OrderResultDTOS> orderResultDTOS = orderService.findAllOrderStatusPending();
        return new ResponseEntity<>(orderResultDTOS, HttpStatus.OK);
    }
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

    @PatchMapping("/update")
    public ResponseEntity<?> changeStatusOrder(@RequestBody OrderChangeStatus orderChangeStatus){

        return new ResponseEntity<>(orderService.changeStatus(orderChangeStatus),HttpStatus.ACCEPTED);

    }

    @GetMapping("/getAllRole")
    public ResponseEntity<?> getCreatedBy(){
        List<Role> roleResults = roleService.findAllRole();
        return new ResponseEntity<>(roleResults,HttpStatus.OK);

    }

    @GetMapping("/byIdUser/{idUser}")
    public ResponseEntity<?> getOrderByIdUser(@PathVariable Long idUser) {

        List<OrderResult> orderListPurchaseList = orderService.findAllByUserId(idUser);

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
    }
    @GetMapping("/paymentPurchase/{id}")
    public ResponseEntity<?> getAllPaymentPurchase(@PathVariable Long id) {
        List<PaymentResult> listPaymentPurchase = paymentPurchaseService.findAllByUserId(id);
        return new ResponseEntity<>(listPaymentPurchase, HttpStatus.OK);
    }

    @GetMapping("/paymentCustomer/{id}")
    public ResponseEntity<?> getAllPaymentCustomer(@PathVariable Long id) {
        List<PaymentCustomerResult> listPaymentCustomer = paymentCustomerService.getPaymentByUserId(id);
        return new ResponseEntity<>(listPaymentCustomer, HttpStatus.OK);
    }

    @GetMapping("/totalOrderOM")
    public ResponseEntity<?> totalOrderOM() {
        return new ResponseEntity<>(orderService.totalOrderOneMonth(), HttpStatus.OK);
    }

     @PostMapping("/payable")
    public  ResponseEntity<?> doPaid(@RequestBody OrderPaid orderPaid){

        return new ResponseEntity<>(orderService.doPaid(orderPaid),HttpStatus.ACCEPTED);

    }

    @PostMapping("/paymentCustomer")
    public  ResponseEntity<?> doPaidCustomer(@RequestBody OrderCustomerPaid orderCustomerPaid){

        return new ResponseEntity<>(orderService.doPaidCustomer(orderCustomerPaid),HttpStatus.ACCEPTED);
    }

}
