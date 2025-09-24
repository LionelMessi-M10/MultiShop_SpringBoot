package com.multishop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class UserShopPermissionId implements Serializable {
	private Long userId;
	private Long shopId;
	private Long permissionId;
}
