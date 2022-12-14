package com.cg.repositories;

import com.cg.dto.payment.ChartDebt;
import com.cg.dto.payment.ListPaymentUser;
import com.cg.repositories.model.PaymentCustomer;
import com.cg.repositories.model.PaymentPurchase;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface PaymentCustomerRepository extends JpaRepository<PaymentCustomer, Long> {

    List<PaymentCustomer> findAllByUserId(Long id);

    List<PaymentCustomer> findAllByOrderId(Long orderId);

    @Query(name = "sp_getPaymentUser" , nativeQuery = true)
    List<ListPaymentUser> getPaymentUser();

    @Query(name =  "sp_getChartDebtCus", nativeQuery = true)
    List<ChartDebt> getChartDebtCus();
}
