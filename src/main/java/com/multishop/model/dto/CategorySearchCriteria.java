package com.multishop.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySearchCriteria {
    private String keySearch;
    private Byte status;
    private Long shopId;

    // nếu true → chỉ lấy category cha
    private Boolean parentOnly;

    // nếu true → chỉ lấy category con
    private Boolean childrenOnly;

    // nếu có → chỉ lấy category con của parent cụ thể
    private Long parentId;

    private int pageNo = 0;
    private int pageSize = 10;
    
}
