package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

=======
>>>>>>> development
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
<<<<<<< HEAD
@Accessors(chain = true)
=======
>>>>>>> development
public class Order {

    public Order(Long userId){
        this.user = new User(this.userId = userId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grand_total", nullable = false, precision = 12)
    private BigDecimal grandTotal;

    @Column(name = "user_id",nullable = false, insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

<<<<<<< HEAD
    @Column(nullable = false)
    private String address;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Order(long id){
        this.id = id ;
    }
=======
    @Column(name = "created_by", nullable = false)
    private Long createdBy;
>>>>>>> development

    @Column(name = "address", nullable = false, length = 95)
    private String address;

    @Column(name = "created_at")
    private Instant createdAt;


    public Order(Long id) {
        this.id= id;
    }
}