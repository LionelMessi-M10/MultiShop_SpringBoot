package com.multishop.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySearchCriteria {
    private int pageNo = 0;
    private int pageSize = 10;
    private String keySearch;
    private Boolean status;   // ví dụ nếu category có trạng thái enable/disable
    private Long shopId;      // tìm theo shop cụ thể
    private Long parentId;    // tìm theo parent category
}
