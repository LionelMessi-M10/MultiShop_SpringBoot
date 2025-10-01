package com.multishop.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.multishop.entity.Category;
import com.multishop.model.dto.CategorySearchCriteria;
import com.multishop.repository.custom.CategoryRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Category> searchCategories(CategorySearchCriteria criteria) {
        StringBuilder jpql = new StringBuilder("SELECT c FROM Category c WHERE 1=1 ");
        StringBuilder countJpql = new StringBuilder("SELECT COUNT(c) FROM Category c WHERE 1=1 ");
        List<Object> params = new ArrayList<>();

        // keySearch theo name
        if (criteria.getKeySearch() != null && !criteria.getKeySearch().isEmpty()) {
            jpql.append(" AND LOWER(c.name) LIKE LOWER(CONCAT('%', ?1, '%')) ");
            countJpql.append(" AND LOWER(c.name) LIKE LOWER(CONCAT('%', ?1, '%')) ");
            params.add(criteria.getKeySearch());
        }

        // status
        if (criteria.getStatus() != null) {
            jpql.append(" AND c.status = ?").append(params.size() + 1);
            countJpql.append(" AND c.status = ?").append(params.size() + 1);
            params.add(criteria.getStatus());
        }

        // shopId
        if (criteria.getShopId() != null) {
            jpql.append(" AND c.shop.id = ?").append(params.size() + 1);
            countJpql.append(" AND c.shop.id = ?").append(params.size() + 1);
            params.add(criteria.getShopId());
        }

        // parentId
        if (criteria.getParentId() != null) {
            jpql.append(" AND c.parent.id = ?").append(params.size() + 1);
            countJpql.append(" AND c.parent.id = ?").append(params.size() + 1);
            params.add(criteria.getParentId());
        }

        TypedQuery<Category> query = entityManager.createQuery(jpql.toString(), Category.class);
        TypedQuery<Long> countQuery = entityManager.createQuery(countJpql.toString(), Long.class);

        // set params
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
            countQuery.setParameter(i + 1, params.get(i));
        }

        // phân trang
        query.setFirstResult(criteria.getPageNo() * criteria.getPageSize());
        query.setMaxResults(criteria.getPageSize());

        List<Category> results = query.getResultList();
        Long total = countQuery.getSingleResult();

        return new PageImpl<>(results, PageRequest.of(criteria.getPageNo(), criteria.getPageSize()), total);
    }
}