package com.multishop.converter;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.multishop.entity.Province;
import com.multishop.model.dto.ProvinceDTO;

@Configuration
public class ProvinceConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Province convertDTOToEntity(Map<String, Object> item) {		
		Province entity = new Province();
        entity.setProvinceId((Integer) item.get("ProvinceID"));
        entity.setProvinceName((String) item.get("ProvinceName"));
        return entity;
	}
	
	public ProvinceDTO convertEntityDto(Province province) {
		return modelMapper.map(province, ProvinceDTO.class);
	}
	
}
