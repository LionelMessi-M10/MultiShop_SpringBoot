package com.multishop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class RolePermissionId implements Serializable {
	private Long roleId;
	private Long permissionId;
}
