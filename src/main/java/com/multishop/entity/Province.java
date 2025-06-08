package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provinces")
@Getter 
@Setter
public class Province extends Base {

    private String name;

    @OneToMany(mappedBy = "province")
    private List<District> districts;
}

