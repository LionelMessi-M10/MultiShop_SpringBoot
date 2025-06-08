package com.multishop.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coupons")
@Getter 
@Setter
public class Coupon extends Base {
    private String code;
    private String discountType; // percent/fixed
    private Float discountValue;
    private int quantity;
    private LocalDateTime expiryDate;

    @OneToMany(mappedBy = "coupon")
    private List<CouponUser> usages;
}
