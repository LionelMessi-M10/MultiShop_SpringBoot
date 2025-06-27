package com.multishop.entity;

import java.util.List;

import com.multishop.enums.ProductStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends Base {

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "origin_price")
	private Double originPrice; // giá gốc
	
	@Column(name = "sale_price")
	private Double salePrice; // giá bán
	
	@Column(name = "discount")
	private Float discount;

	@Column(name = "sale_quantity")
	private Long saleQuantity; // số lượng bán được
	
	@Column(name = "stock")
	private Long stock; // Số lượng tồn kho
	
	@Column(name = "brand")
	private String brand; // Thương hiệu sản phẩm
	
	@Column(name = "sku", length = 100)
	private String sku; // mã sản phẩm nội bộ
	
	@Column(name = "weight", nullable = false)
	@NotNull
	@NotBlank
	private Float weight; // cân nặng sản phẩm
	
	@Column(name = "dimensions")
	private String dimensions; // kích thước sản phẩm
	
	@Column(name = "product_status")
	@Enumerated(EnumType.STRING)
	private Enum<ProductStatus> productStatus; // Trình trạng sản phẩm
	
	@Column(name = "is_feature")
	private Boolean isFeature; // Có phải là sản phẩm nổi bật
	
	@Column(name = "average_rating")
	private Float averageRating; // Số trung bình đánh giá (Tính toán từ review)
	
	@Column(name = "review_count")
	private Integer reviewCount; // Số lượng người dùng review
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
    private Category categories;
	
	@ManyToOne
	@JoinColumn(name = "sub_category_id", nullable = true)
	private SubCategory subCategory;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product")
    private List<ProductAttributeValue> attributeValues;
	
    @ManyToOne
    @JoinColumn(name = "shop_id")
	private Shop shop;
}
