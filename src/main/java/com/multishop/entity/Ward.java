package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wards")
@Getter 
@Setter
public class Ward extends Base {

	@Column(name = "ward_code")
	private Integer wardCode;
	
	@Column(name = "ward_name")
    private String wardName;

    @Column(name = "district_id")
    private Integer districtId;
}

