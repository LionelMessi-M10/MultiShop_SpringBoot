package com.multishop.service;

import java.util.List;

import com.multishop.model.dto.ProvinceDTO;

public interface GhnService {
	
	List<ProvinceDTO> getAllProvince();
	
	void saveProvine();
	void saveDistrict();
	void saveWard();
	
}