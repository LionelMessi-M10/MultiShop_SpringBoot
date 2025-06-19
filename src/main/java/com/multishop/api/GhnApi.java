package com.multishop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.dto.ProvinceDTO;
import com.multishop.service.GhnService;

@RestController
@RequestMapping("/api")
public class GhnApi {
	
	@Autowired
	private GhnService ghnService;
	
	@PostMapping("/admin/province")
	public void handleSaveProvince() {
		ghnService.saveProvine();
	}
	
	@GetMapping("/province")
	public ResponseEntity<ProvinceDTO> getAllProvince() {


		return null;
	}

}
