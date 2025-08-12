package com.multishop.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multishop.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getUserRoleShops().stream()
                .flatMap(userRoleShop -> userRoleShop.getRole().getRolePermissions().stream())
                .map(rolePermission -> new SimpleGrantedAuthority(rolePermission.getPermission().getCode()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }
    // ... các phương thức khác của UserDetails
}