package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter 
@Setter
public class Address extends BaseEntity {
	
	@Column(name = "address_detail")
    private String addressDetail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne @JoinColumn(name = "ward_id")
    private Ward ward;
}

