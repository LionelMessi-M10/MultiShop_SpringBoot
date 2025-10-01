package com.multishop.controller.shop;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.entity.Category;
import com.multishop.model.request.CategoryRequest;
import com.multishop.model.response.CategoryResponse;
import com.multishop.payload.ApiResponse;
import com.multishop.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shops")
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getAllCategories(
	        @RequestParam(defaultValue = "0") int pageNo,
	        @RequestParam(defaultValue = "10") int pageSize
	) {

	    Page<CategoryResponse> result = categoryService.getAll(pageNo, pageSize);

	    return ResponseEntity.ok(
	        ApiResponse.success(
	            HttpStatus.OK,
	            result,
	            "Get all categories successfully"
	        )
	    );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		return ResponseEntity.ok(
			ApiResponse.success(
				HttpStatus.OK, categoryService.getById(id), "Found category by id: " + id)
			);
	}

	@PostMapping
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
		CategoryResponse newCategory = categoryService.create(categoryRequest);
		return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED, newCategory, "Create category successfully"));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id ,@Valid @RequestBody CategoryRequest categoryRequest) {
		CategoryResponse updateCategory = categoryService.update(id, categoryRequest);
		return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK, updateCategory, "Update category successfully"));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id) {
		CategoryResponse deleteCategory = categoryService.delete(id);
		return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK, deleteCategory, "Delete category successfully"));
	}
}
