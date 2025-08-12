package com.multishop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Permission extends Base {

    @Column(nullable = false, length = 100, unique = true)
    private String code; // Mã quyền, ví dụ: "PRODUCT_WRITE"

    @Column(columnDefinition = "TEXT")
    private String name; // Tên hiển thị của quyền, ví dụ: "Tạo/Sửa sản phẩm"

}