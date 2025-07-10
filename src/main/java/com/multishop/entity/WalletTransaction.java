package com.multishop.entity;

import com.multishop.enums.WalletTransactionStatus;
import com.multishop.enums.WalletTransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "wallet_transactions")
public class WalletTransaction extends Base { // Giao dịch ví
	
	@ManyToOne
	@JoinColumn(name = "wallet_id", nullable = false)
	private Wallet wallet;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private WalletTransactionType type; // Loại giao dịch ví
	
	@Column(name = "amount")
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "wallet_transaction_status")
	private WalletTransactionStatus walletTransactionStatus;

	@Column(name = "reference_id")
	private Long referentceId; // Tham chiếu đến Order ID, Payment ID, ...
	
	@Lob
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
}
