package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter 
@Setter
public class CartEntity extends BaseEntity {
	
    @OneToOne @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items;
}
