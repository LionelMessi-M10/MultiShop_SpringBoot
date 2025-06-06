package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter 
@Setter
public class OrderEntity extends BaseEntity {
    @ManyToOne 
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusLog> statusLogs;

    private String statusOrder;
    private Double totalPrice;
}
