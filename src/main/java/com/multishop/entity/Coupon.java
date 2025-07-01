package com.multishop.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.multishop.enums.DiscountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@Entity
@Table(name = "coupons")
public class Coupon extends Base {
	
	@Column(name = "code", nullable = false, unique = true)
    private String code; // Ma giam gia
	
	@Enumerated(EnumType.STRING)
	@Column(name = "discount_type", nullable = false)
    private Enum<DiscountType> discountType;
	
	@Column(name = "discount_value", nullable = false)
    private Float discountValue; // ví dụ: 10.0 cho 10%, 50000.0 cho 50K

	@Column(name = "min_order_amount")
	private Double minOrderAmount; // giá trị tổi thiểu đơn hàng để áp dụng

	@Column(name = "max_order_amount")
	private Double maxOrderAmount; // giá trị tổi đa đơn hàng để áp dụng

	@Column(name = "usage_limit")
	private Integer usageLimit; // Số lần sử dụng, nếu không có thì dngf vô hạn

	@Column(name = "used_count")
	private Integer usedCount; // Số lần sử dụng coupon
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "coupon")
    private List<CouponUser> usages;
}
