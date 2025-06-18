package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provinces")
@Getter 
@Setter
public class Province extends Base {

	@Column(name = "province_id")
	private Integer provinceId;
	
	@Column(name = "provice_name")
    private String provinceName;

}

