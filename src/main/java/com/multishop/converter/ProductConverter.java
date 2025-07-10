package com.multishop.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.multishop.entity.Product;
import com.multishop.model.dto.ProductDTO;
import com.multishop.model.response.ProductReponse;

@Configuration
public class ProductConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProductReponse convertEntityToReponse(Product product) {
		ProductReponse productReponse = modelMapper.map(product, ProductReponse.class);
		
		if(product.getStatus() == 0) {
			productReponse.setStatus("In Active");
		}
		else if(product.getStock() > 0 && product.getStatus() == 1) {
			productReponse.setStatus("Active");
		}
		else if(product.getStock() == 0) {
			productReponse.setStatus("Out Stock");
		}
		
		return productReponse;
	}
	
	public ProductDTO convertEntityToDto(Product product) {
		ProductDTO productDTO = new ProductDTO();
		
		return productDTO;
	}
	
}
