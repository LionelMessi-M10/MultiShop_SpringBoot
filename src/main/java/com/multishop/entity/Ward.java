package com.multishop.entity;

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
public class Ward extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}

