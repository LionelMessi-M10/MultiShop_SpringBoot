package com.multishop.api.seller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.dto.ProvinceDTO;
import com.multishop.service.GhnService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GhnApi {

    private final GhnService ghnService;

    @PostMapping("/admin/province")
    public void handleSaveProvince() {
        ghnService.saveProvine();
    }

    @GetMapping("/province")
    public ResponseEntity<ProvinceDTO> getAllProvince() {

        return null;
    }

}
