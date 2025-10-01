package com.multishop.specification;

import org.springframework.data.jpa.domain.Specification;
import com.multishop.entity.Category;
import com.multishop.model.dto.CategorySearchCriteria;

public class CategorySpecification {

	/*
	 * 
	 * root: Đại diện cho entity gốc mà bạn đang query (ở đây là Category). Ví dụ:
	 * root.get("name") tương ứng với cột name trong bảng categories. Nếu quan hệ
	 * ManyToOne/OneToMany thì có thể truy cập như root.get("shop").get("id").
	 * 
	 * query Đại diện cho câu truy vấn JPA đang được build. Thường ít dùng trực
	 * tiếp, trừ khi bạn muốn chỉnh SELECT DISTINCT, JOIN fetch, hoặc ORDER BY.
	 * 
	 * cb (CriteriaBuilder) Là công cụ để tạo ra các biểu thức điều kiện
	 * (Predicate). Ví dụ: cb.equal(root.get("status"), true) → WHERE status = true
	 * cb.like(cb.lower(root.get("name")), "%phone%") → WHERE LOWER(name) LIKE
	 * '%phone%' cb.conjunction() → điều kiện “luôn đúng” (thường dùng khi không có
	 * filter).
	 * 
	 * Tóm lại: root → ánh xạ entity → cột trong bảng. cb → tạo điều kiện filter.
	 * predicates → tập hợp điều kiện WHERE. Repository (nhờ
	 * JpaSpecificationExecutor) → nhận Spec, dịch sang SQL, query DB
	 * 
	 */

	public static Specification<Category> filter(CategorySearchCriteria criteria) {
	    Specification<Category> spec = Specification
	            .where(hasKeySearch(criteria.getKeySearch()))
	            .and(hasStatus(criteria.getStatus()))
	            .and(hasShopId(criteria.getShopId()))
	            .and(hasParentId(criteria.getParentId()));

	    // chỉ dùng parentOrChildren khi không filter theo parentId
	    if (criteria.getParentId() == null) {
	        spec = spec.and(parentOrChildren(criteria.getParentOnly(), criteria.getChildrenOnly()));
	    }

	    return spec;
	}


    public static Specification<Category> hasKeySearch(String keySearch) {
        return (root, query, cb) -> {
            if (keySearch == null || keySearch.isEmpty()) {
                return null;
            }
            return cb.like(cb.lower(root.get("name")), "%" + keySearch.toLowerCase() + "%");
        };
    }

    public static Specification<Category> hasStatus(Byte status) {
        return (root, query, cb) -> {
            if (status  == null) return null;
            return cb.equal(root.get("status"), status);
        };
    }

    public static Specification<Category> hasShopId(Long shopId) {
        return (root, query, cb) -> {
            if (shopId == null) return null;
            return cb.equal(root.get("shop").get("id"), shopId);
        };
    }

    public static Specification<Category> hasParentId(Long parentId) {
        return (root, query, cb) -> {
            if (parentId == null) return null;
            return cb.equal(root.get("parent").get("id"), parentId);
        };
    }

    public static Specification<Category> parentOrChildren(Boolean parentOnly, Boolean childrenOnly) {
        return (root, query, cb) -> {
            if (Boolean.TRUE.equals(parentOnly)) {
                return cb.isNull(root.get("parent")); // chỉ parent
            }
            if (Boolean.TRUE.equals(childrenOnly)) {
                return cb.isNotNull(root.get("parent")); // chỉ children
            }
            // mặc định lấy parent thôi để xây tree
            return cb.isNull(root.get("parent"));
        };
    }

}
