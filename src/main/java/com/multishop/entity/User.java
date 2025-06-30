package com.multishop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @NotNull
    @NotBlank
    private String fullName;

    @NotBlank(message = "Email không được trống")
    @Email(message = "Email không đúng định dạng")
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "phone_number", length = 12, unique = true)
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "gender", length = 10)
    private Byte gender;
    
    @Column(name = "avartar_url")
    private String avartarUrl;
    
    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;
    
    @Column(name = "enabled")
    private Integer enabled = 1;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Role> roles = new ArrayList<>();
    
    @OneToOne(mappedBy = "user")
    private Shop shop;
    
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Order> orders;
}
