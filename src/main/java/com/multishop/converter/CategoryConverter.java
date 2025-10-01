package com.multishop.converter;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.multishop.model.request.CategoryRequest;
import com.multishop.model.response.CategoryResponse;

import lombok.RequiredArgsConstructor;

import com.multishop.entity.Category;
import com.multishop.entity.Shop;

@RequiredArgsConstructor
@Component
public class CategoryConverter {
	
	private final ModelMapper modelMapper;

    public Category toEntity(CategoryRequest request, Category parent, Shop shop) {
        Category category = new Category();
        
        category.setName(request.getName());
        category.setImage(request.getImage());
        
        if(parent != null) category.setParent(parent);
        if(shop != null) category.setShop(shop);
        return category;
    }

    public void updateEntity(Category category, CategoryRequest request, Category parent, Shop shop) {
        category.setName(request.getName());
        category.setImage(request.getImage());
        category.setStatus(request.getStatus());
        
        if(parent != null) category.setParent(parent);
        if(shop != null) category.setShop(shop);
    }

    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = modelMapper.map(category, CategoryResponse.class);

        if (category.getParent() != null) {
            response.setCategoryParentId(category.getParent().getId());
            response.setCategoryParentName(category.getParent().getName());
        }

        if (category.getShop() != null) {
            response.setShopId(category.getShop().getId());
            response.setShopName(category.getShop().getShopName());
        }
        
        if (category.getChildren() != null && !category.getChildren().isEmpty()) {
        	response.setChildren(
                category.getChildren().stream()
                        .map(this::toResponse) // đệ quy
                        .collect(Collectors.toList())
            );
        }
        
        return response;
    }
}
