package com.multishop.entity;

import com.multishop.enums.PaymentMethod;
import com.multishop.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment extends Base {

	@Column(name = "transaction_id", unique = true)
	private String transactionId; // Mã giao dịch thanh toán, nếu có
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "currency", length = 10)
	private String currency;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method", nullable = false)
	private Enum<PaymentMethod> paymentMethod;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "paymentStatus", nullable = false)
	private Enum<PaymentStatus> paymentStatus;
	
	@Lob
	@Column(name = "bank_response", columnDefinition = "TEXT")
	private String bankResponse;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
