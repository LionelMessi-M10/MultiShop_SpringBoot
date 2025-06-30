package com.multishop.entity;

import java.util.List;

import com.multishop.enums.ActiveStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(name = "logo")
	private String logo;
	
	@Column(name = "cover_image")
	private String coverImage; // Ảnh bìa cửa hàng
	
	@Column(name = "action")
	@Enumerated(EnumType.STRING)
	private Enum<ActiveStatus> action; // trạng thái hoạt động của cửa hàng
	
	@Column(name = "rating")
	private Float rating;
	
	@OneToOne
	@JoinColumn(name = "seller_id")
	private User user;
	
	@OneToMany(mappedBy = "shop", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<Product> products;
	
	@OneToMany(mappedBy = "shop", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Order> orders;
	
}
