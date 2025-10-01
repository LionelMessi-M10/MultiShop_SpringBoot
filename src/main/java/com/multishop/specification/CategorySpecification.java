package com.multishop.specification;

import org.springframework.data.jpa.domain.Specification;
import com.multishop.entity.Category;

public class CategorySpecification {

	/*
	
	 root:
		Đại diện cho entity gốc mà bạn đang query (ở đây là Category).
		Ví dụ: 
			root.get("name") tương ứng với cột name trong bảng categories.
			Nếu quan hệ ManyToOne/OneToMany thì có thể truy cập như root.get("shop").get("id").
		
	 query
		Đại diện cho câu truy vấn JPA đang được build.
		Thường ít dùng trực tiếp, trừ khi bạn muốn chỉnh SELECT DISTINCT, JOIN fetch, hoặc ORDER BY.
		
	 cb (CriteriaBuilder)
		Là công cụ để tạo ra các biểu thức điều kiện (Predicate).
		Ví dụ:
			cb.equal(root.get("status"), true) → WHERE status = true
			cb.like(cb.lower(root.get("name")), "%phone%") → WHERE LOWER(name) LIKE '%phone%'
			cb.conjunction() → điều kiện “luôn đúng” (thường dùng khi không có filter).

	 Tóm lại:
		root → ánh xạ entity → cột trong bảng.
		cb → tạo điều kiện filter.
		predicates → tập hợp điều kiện WHERE.
		Repository (nhờ JpaSpecificationExecutor) → nhận Spec, dịch sang SQL, query DB
		
	 */
	
    public static Specification<Category> hasKeySearch(String keySearch) {
        return (root, query, cb) -> {
            if (keySearch == null || keySearch.trim().isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("name")), "%" + keySearch.toLowerCase() + "%");
        };
    }

    public static Specification<Category> hasStatus(Boolean status) {
        return (root, query, cb) -> {
            if (status == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("status"), status);
        };
    }

    public static Specification<Category> hasShopId(Long shopId) {
        return (root, query, cb) -> {
            if (shopId == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("shop").get("id"), shopId);
        };
    }
}
