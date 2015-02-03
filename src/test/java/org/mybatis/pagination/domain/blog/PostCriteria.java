package org.mybatis.pagination.domain.blog;

import org.mybatis.pagination.dto.datatables.BasePageCriteria;
import org.mybatis.pagination.dto.datatables.PagingCriteria;

/**
 * Created by qilei on 2015/2/3.
 */
public class PostCriteria extends BasePageCriteria {
    private Integer autherId;

    public PostCriteria(PagingCriteria page) {
        super(page);
    }

    public Integer getAutherId() {
        return autherId;
    }

    public void setAutherId(Integer autherId) {
        this.autherId = autherId;
    }
}
