package com.cg.dto.orderDTO;

import com.cg.repositories.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
<<<<<<< HEAD

@Data
@AllArgsConstructor
@NoArgsConstructor
=======
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
>>>>>>> development
@Accessors(chain = true)
public class OrderResult {

    private Long id;

    private BigDecimal grandTotal;

<<<<<<< HEAD
    private Long userId;

    private Long createdBy;

    private String address;

    private OrderStatus status;
=======
    private long userId;

    private OrderStatus orderStatus;

    private String address;

    private long createdBy;

    private Instant createdAt;
>>>>>>> development
}
