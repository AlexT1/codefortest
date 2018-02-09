package com.alexstudy.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author AlexTong
 * @ClassName MongoGenDao
 * @Description TODO()
 * @date 2018/1/17 15:43:44
 */
public abstract class MongoGenDao<T> {
    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 保存一个对象
     *
     * @param t
     * @return
     */
    public void save(T t){
        this.mongoTemplate.save(t);
    }

    /**
     * 为属性自动注入bean服务
     *
     *
     * @param mongoTemplate
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    protected abstract Class<T> getEntityClass();
}
