package com.multishop.api.seller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.dto.ProductDTO;
import com.multishop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        ProductDTO productDTO = productService.getProductById(id);

        if (productDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productDTO);
    }
}
