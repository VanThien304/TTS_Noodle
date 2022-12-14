package com.cg.dto.order_item;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderItemResult {

    private Long id;

    private BigDecimal price;

    private Integer quantity;

    private Long productId;

    private Long orderId;

    private Long itemId;

}
