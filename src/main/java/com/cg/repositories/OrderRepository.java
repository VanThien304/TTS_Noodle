package com.cg.repositories;

import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
<<<<<<< HEAD

    @Query("SELECT NEW com.cg.dto.orderDTO.OrderResult (" +
            "o.id, " +
            "o.grandTotal, " +
            "o.userId, " +
            "o.createdBy, " +
            "o.address, " +
            "o.orderStatus" +
            ")" +
            "FROM Order o " +
            "WHERE o.userId = ?1")
    List<OrderResult> getAllOrderByUserId(Long userId);

=======
//    @Query(value =
//            "SELECT * FROM orders o join users u  on  o.created_by = u.id")
//
>>>>>>> development
}
