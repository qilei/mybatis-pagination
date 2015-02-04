package org.mybatis.pagination.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.pagination.domain.ResourcesPageCriteria;
import org.mybatis.pagination.domain.blog.Author;
import org.mybatis.pagination.domain.blog.Post;
import org.mybatis.pagination.domain.blog.PostCriteria;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.mapper.AuthorMapper;
import org.mybatis.pagination.mapper.PostMapper;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by qilei on 2015/2/3.
 */
public class PostMapperTest extends BaseDataTest {
    private static SqlSessionFactory sqlMapper;

    @BeforeClass
    public static void setup() throws Exception {
        createBlogDataSource();
        final String resource = "spring/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void selectAllPosts() {
        SqlSession session = sqlMapper.openSession();
        try {
            PostMapper mapper = session.getMapper(PostMapper.class);
            List<Map> posts = mapper.selectAllPosts();
            assertTrue(posts.size()>0);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectPostJoinedWithAuthor() {
        SqlSession session = sqlMapper.openSession();
        try {
            PostMapper mapper = session.getMapper(PostMapper.class);
            List<Post> posts = mapper.selectPostJoinedWithAuthor();
            assertTrue(posts.size()>0);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectByPage() {
        SqlSession session = sqlMapper.openSession();
        try {
            PostMapper mapper = session.getMapper(PostMapper.class);
            PagingCriteria baseCriteria = PagingCriteria.createCriteria(0, 10, 1);
            PostCriteria criteria = new PostCriteria(baseCriteria);
            criteria.setAutherId(102);
            PageMyBatis<Post> posts = mapper.selectByPage(criteria);
            assertTrue(posts.size()>0);
        } finally {
            session.close();
        }
    }

}
