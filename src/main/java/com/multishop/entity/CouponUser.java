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
public class CouponUser extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private CouponEntity coupon;

    @ManyToOne 
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime usedAt;
}
