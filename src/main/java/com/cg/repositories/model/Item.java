package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "items")
 public class Item {

    public Item(Long id) {
    this.id = id;
}

    public Item(Long productId, Long userId, Long orderId) {
        setProductId(productId);
        setUserId(userId);
        setOrderId(orderId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "users_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "price", nullable = false, precision = 12)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "sold", nullable = false)
    private int sold;

    @Column(name = "available", nullable = false)
    private int available;

    @Column(name = "defective", nullable = false)
    private int defective;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;


    public Item setOrderId(Long orderId) {
        this.order = new Order(this.orderId = orderId);
        return this;
    }

    public Item setProductId(Long productId) {
        this.product = new Product(this.productId = productId);
        return this;
    }

    public Item setUserId(Long userId) {
        this.user = new User(this.userId = userId);
        return this;
    }
}