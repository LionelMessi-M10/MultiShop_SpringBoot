package com.multishop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name = "user_role_shop")
@Data
@NoArgsConstructor
public class UserRoleShop {

    @EmbeddedId
    private UserRoleShopId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopId")
    @JoinColumn(name = "shop_id")
    private Shop shop;
}

@Embeddable
@Data
@NoArgsConstructor
class UserRoleShopId implements Serializable {
    private Long userId;
    private Long roleId;
    private Long shopId;
}