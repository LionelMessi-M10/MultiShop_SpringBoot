package com.multishop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class RolePermissionId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long roleId;
	private Long permissionId;
}
