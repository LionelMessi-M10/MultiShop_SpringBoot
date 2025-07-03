package com.multishop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name = "shop_shipping_methods")
public class ShopShippingMethod extends Base {

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;
	
	@ManyToOne
	@JoinColumn(name = "shipping_method_id")
	private ShippingMethod shippingMethod;
	
}
