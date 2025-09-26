package com.multishop.service.impl;

import com.multishop.converter.CategoryConverter;
import com.multishop.model.request.CategoryRequest;
import com.multishop.model.response.CategoryResponse;
import com.multishop.entity.Category;
import com.multishop.entity.Shop;
import com.multishop.repository.CategoryRepository;
import com.multishop.repository.ShopRepository;
import com.multishop.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category parent = null;
        if (request.getParentId() != null) {
            parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found: " + request.getParentId()));
        }

        Shop shop = null;
        if (request.getShopId() != null) {
            shop = shopRepository.findById(request.getShopId())
                    .orElseThrow(() -> new RuntimeException("Shop not found: " + request.getShopId()));
        }

        Category category = categoryConverter.toEntity(request, parent, shop);
        category = categoryRepository.save(category);
        return categoryConverter.toResponse(category);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));

        Category parent = null;
        if (request.getParentId() != null) {
            parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found: " + request.getParentId()));
        }

        Shop shop = null;
        if (request.getShopId() != null) {
            shop = shopRepository.findById(request.getShopId())
                    .orElseThrow(() -> new RuntimeException("Shop not found: " + request.getShopId()));
        }

        categoryConverter.updateEntity(category, request, parent, shop);
        category = categoryRepository.save(category);
        return categoryConverter.toResponse(category);
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        return categoryConverter.toResponse(category);
    }

    @Override
    public Page<CategoryResponse> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").ascending());
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(categoryConverter::toResponse);
    }
}
