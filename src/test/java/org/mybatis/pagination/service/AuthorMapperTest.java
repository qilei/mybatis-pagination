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
package org.mybatis.pagination.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.pagination.domain.blog.Author;
import org.mybatis.pagination.mapper.AuthorMapper;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorMapperTest extends BaseDataTest {
    private static SqlSessionFactory sqlMapper;

    @BeforeClass
    public static void setup() throws Exception {
        createBlogDataSource();
        final String resource = "spring/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void shouldSelectAuthorsUsingMapperClass() {
        SqlSession session = sqlMapper.openSession();
        try {
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            List<Author> authors = mapper.selectAllAuthors();
            assertEquals(2, authors.size());
        } finally {
            session.close();
        }
    }

}
