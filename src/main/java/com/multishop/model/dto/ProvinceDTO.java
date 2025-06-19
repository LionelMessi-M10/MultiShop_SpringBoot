package com.multishop.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProvinceDTO {

	@JsonProperty("ProvinceID")
	private Integer provinceId;

	@JsonProperty("ProvinceName")
	private String provinceName;
}
