package com.multishop.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shippings")
@Getter
@Setter
public class Shipping extends Base {
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String shipCode;
    private String provider;
    private Double fee;
    private String statusShipping;
}
