package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Column;
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
public class Cart extends Base {
	
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items;
}
