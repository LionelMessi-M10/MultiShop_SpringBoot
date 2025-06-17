package com.multishop.entity;

import com.multishop.enums.ShippingMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Order order;
    
    private String address; // Dia chi giao hang
    private String city; // thanh pho
    private String state; // bang hoac khu vuc
    private String postalCode; // ma buu dien
    private String country; // quoc gia
    @Column(name = "shipping_method")
	@Enumerated(EnumType.STRING)
    private Enum<ShippingMethod> shippingMethods; // phuong thuc van chuyen

    private String provider;
    private Double fee;
}
