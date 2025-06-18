package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "districts")
@Getter 
@Setter
public class District extends Base {
	
	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "district_name")
    private String districtName;

    @Column(name = "province_id")
    private Integer provinceId;

}

