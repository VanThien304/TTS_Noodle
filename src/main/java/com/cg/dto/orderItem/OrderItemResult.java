package com.cg.dto.orderItem;


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

    private long itemId;

    private long orderId;

    private long productId;


}
