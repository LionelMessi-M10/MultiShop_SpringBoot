package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "permissions")
public class Permission extends Base {

    @Column(nullable = false, length = 100, unique = true)
    private String code; // Mã quyền, ví dụ: "CREATE_PRODUCT", "VIEW_ORDER"

    @Column(columnDefinition = "TEXT")
    private String name; // Tên hiển thị của quyền, ví dụ: "Tạo/Sửa sản phẩm"

}
