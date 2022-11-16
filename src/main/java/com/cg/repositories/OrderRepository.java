package com.cg.repositories;


import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);





}
