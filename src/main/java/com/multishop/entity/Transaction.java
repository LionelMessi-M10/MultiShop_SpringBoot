package com.multishop.entity;

import com.multishop.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction extends Base {

	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "payment_method")
	@Enumerated(EnumType.STRING)
	private Enum<PaymentMethod> paymentMethod;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
}
