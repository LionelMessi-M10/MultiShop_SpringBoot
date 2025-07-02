package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "return_order_items")
public class ReturnOrderItem extends Base {

	@ManyToOne
	@JoinColumn(name = "return_order_id", nullable = false)
	private ReturnOrder returnOrder;
	
	@OneToOne
	@JoinColumn(name = "order_detail_id", nullable = false)
	private OrderDetail orderDetail;
	
	@Column(name = "quantity")
	private Integer quantity; // Số lượng sản phẩm trả lại

	@Column(name = "refund_amount")
	private Double refundAmount; // Số tiền hoàn lại cho mặt hàng này
	
}
