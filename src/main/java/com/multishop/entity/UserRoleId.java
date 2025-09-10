package com.multishop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Embeddable
@Data
@NoArgsConstructor
class UserRoleId implements Serializable {
    private Long userId;
    private Long roleId;
    private Long shopId;
}
