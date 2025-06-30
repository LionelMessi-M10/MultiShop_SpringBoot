package com.multishop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "orders")
public class Order extends Base {
	
	@Column(name = "total_amount", nullable = false)
    private Double totalAmount; // Tổng tiền đơn hàng sau giảm giá
    
    @Column(name = "shipping_fee", nullable = false)
    private Float shippingFee;
    
    @Column(name = "discount_amount", nullable = false)
    private Double discountAmount; // Tổng tiền giảm từ coupon/voucher
	
    @Column(name = "final_amount", nullable = false)
    private Double finalAmount;
    
    @ManyToOne 
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<OrderDetail> details;
    
    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusLog> statusLogs;
    
    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Transaction> transactions;
    
}
