package org.mybatis.pagination.performance;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.pagination.domain.blog.Author;
import org.mybatis.pagination.domain.blog.Post;
import org.mybatis.pagination.domain.blog.PostCriteria;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.mapper.AuthorMapper;
import org.mybatis.pagination.mapper.PostMapper;
import org.mybatis.pagination.service.BaseDataTest;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by qilei on 2015/2/6.
 */
public class LimitQuery extends BaseDataTest {
    private static SqlSessionFactory sqlMapper;
    private static int TOTAL_RECORD = 100000;
    private static int PAGE_SIZE = 10;

    @BeforeClass
    public static void setup() throws Exception {
        createBlogDataSourceWithoutData();
        final String resource = "spring/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);

        insertAuthor(TOTAL_RECORD);
    }

    @Test
    public void selectByRowBound() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= TOTAL_RECORD/PAGE_SIZE; i++) {
            selectByRowBound(i);
        }
        long end=System.currentTimeMillis();

        System.out.println("执行游标查询，总记录数："+TOTAL_RECORD+"，每页" + PAGE_SIZE + "，共"+ TOTAL_RECORD/PAGE_SIZE + "页");
        System.out.println("用时(毫秒)："+ (end-start));
    }

    @Test
    public void selectByPage() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= TOTAL_RECORD/PAGE_SIZE; i++) {
            selectByPage(i);
        }
        long end=System.currentTimeMillis();

        System.out.println("执行Limit查询，总记录数："+TOTAL_RECORD+"，每页" + PAGE_SIZE + "，共"+ TOTAL_RECORD/PAGE_SIZE + "页");
        System.out.println("用时(毫秒)：" + (end - start));
    }

    private void selectByRowBound(int page) {
        SqlSession session = sqlMapper.openSession();
        try {
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            int offset = (page-1) * PAGE_SIZE;
            List<Author> authors = mapper.selectByRowBound(new RowBounds(offset,PAGE_SIZE));
            assertEquals(10, authors.size());
        } finally {
            session.close();
        }
    }

    private void selectByPage(int page) {
        SqlSession session = sqlMapper.openSession();
        try {
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            int displayStart = (page-1) * PAGE_SIZE;
            PagingCriteria baseCriteria = PagingCriteria.createCriteria(displayStart, PAGE_SIZE, page);
            PageMyBatis<Author> authors = mapper.selectByPage(baseCriteria);
            assertEquals(10, authors.size());
        } finally {
            session.close();
        }
    }

    private static void insertAuthor(int count) {
        SqlSession session = sqlMapper.openSession();
        try {
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            Author author;
            for (int i = 0; i < count; i++) {
                author = new Author();
                author.setId(i);
                author.setUsername("username" + i);
                author.setPassword("password" + i);
                author.setEmail("email" + i);
                author.setBio("bio" + i);
                author.setFavouriteSection("favouriteSection" + i);
                mapper.insert(author);
            }
            session.commit();
        } finally {
            session.close();
        }
    }

}
