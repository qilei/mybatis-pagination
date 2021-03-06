/*
 *    Copyright 2009-2011 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.pagination.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.pagination.domain.blog.Author;
import org.mybatis.pagination.domain.blog.Post;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;

import java.util.*;

public interface AuthorMapper {

    void insert(Author author);

  List<Author> selectAllAuthors();

    List<Author> selectByRowBound(RowBounds rowBounds);

    PageMyBatis<Author> selectByPage(PagingCriteria criteria);

}
