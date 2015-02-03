package org.mybatis.pagination.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.pagination.domain.*;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.extra.MyBatisRepository;

import java.util.List;

@MyBatisRepository
public interface ResourcesSubMapper {
    int insertSelective(ResourcesSub record);

    PageMyBatis<ComplexResourcesSub> selectByPage(PagingCriteria pagingCriteria);
}