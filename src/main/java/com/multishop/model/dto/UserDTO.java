package com.multishop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String fullName;
	private String telephone;
	private String email;
	private String password;
	private Byte gender;
	private Long roleId;
	
}
