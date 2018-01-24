package com.alexstudy.dao;

import com.alexstudy.base.MongoGenDao;
import com.alexstudy.model.Article;
import com.alexstudy.model.Member;
import org.springframework.stereotype.Repository;

/**
 * @author AlexTong
 * @ClassName ArticleDao
 * @Description TODO()
 * @date 2018/1/17 15:36:59
 */
@Repository
public class ArticleDao extends MongoGenDao<Article> {
    /**
     * 实现钩子方法,返回反射的类型
     *
     * @return
     */
    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
