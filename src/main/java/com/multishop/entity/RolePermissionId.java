package com.multishop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Embeddable
@Data
@NoArgsConstructor
class RolePermissionId implements Serializable {
    private Long roleId;
    private Long permissionId;
}
