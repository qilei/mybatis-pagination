package org.mybatis.pagination.domain;

import com.google.common.collect.Lists;
import org.apache.ibatis.type.Alias;
import org.mybatis.pagination.dto.datatables.BasePageCriteria;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.dto.datatables.SearchField;
import org.mybatis.pagination.dto.datatables.SortField;

import java.util.List;

/**
 * Created by qilei on 2015/1/26.
 */
//@Alias("resPagingCriteria")
public class ResourcesPageCriteria extends BasePageCriteria {
    private String name;

    public ResourcesPageCriteria(PagingCriteria page) {
        super(page);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
