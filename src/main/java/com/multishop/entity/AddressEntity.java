package com.multishop.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressEntity extends BaseEntity {

    @Column(name = "address_detail", nullable = false)
    private String addressDetail;

    @Column(name = "ward_code", length = 20)
    private String wardCode;

    @Column(name = "ward_name", length = 100)
    private String wardName;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "is_default")
    private Boolean isDefault;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
