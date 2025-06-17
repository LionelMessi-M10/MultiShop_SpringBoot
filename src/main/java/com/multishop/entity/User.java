package com.multishop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends Base {

    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "gender", length = 10)
    private Byte gender;
    
    @Column(name = "enabled")
    private Integer enabled = 1;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Role> roles = new ArrayList<>();
    
    @OneToOne(mappedBy = "user")
    private Shop shop;
}
