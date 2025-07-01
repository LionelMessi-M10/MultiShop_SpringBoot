package com.multishop.entity;

import com.multishop.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction extends Base {
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private Enum<TransactionType> transactionType;

	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "currency", length = 10, nullable = false)
	private String currency;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "transaction_status")
//	private Enum<PaymentStatus> transactionStatus;
	
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@Lob
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
}
