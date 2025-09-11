package com.multishop.model.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String emal;
    private String password;
    private String roleName; // Ví dụ: "SELLER" hoặc "BUYER"
}
