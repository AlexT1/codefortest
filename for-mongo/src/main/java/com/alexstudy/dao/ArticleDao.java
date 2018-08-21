package com.alexstudy.dao;

import com.alexstudy.Polymorphism.Article;
import com.alexstudy.base.MongoGenDao;
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
