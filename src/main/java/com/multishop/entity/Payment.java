package com.multishop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String method; // vnpay, momo,...
    private String statusPayment;
    private String transactionCode;
}
