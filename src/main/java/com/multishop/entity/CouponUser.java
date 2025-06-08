package com.multishop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coupon_users")
@Getter 
@Setter
public class CouponUser extends Base {
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne 
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime usedAt;
}
