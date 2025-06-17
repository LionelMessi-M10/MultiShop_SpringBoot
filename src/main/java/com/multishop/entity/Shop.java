package com.multishop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shops")
public class Shop extends Base {

	@Column(name = "shop_name")
	@NotNull
	@NotBlank
	private String shopName;
	
	@Column(name = "shop_desc")
	private String shopDesc;
	
	@OneToOne
	@JoinColumn(name = "seller_id")
	private User user;
	
	@OneToMany(mappedBy = "shop", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<Product> products;
	
}
