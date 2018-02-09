package com.alexstudy.dao;


import com.alexstudy.base.MongoGenDao;
import com.alexstudy.Polymorphism.Member;

/**
 * @author AlexTong
 * @ClassName MemberDao
 * @Description TODO()
 * @date 2018/1/17 15:49:36
 */
public class MemberDao extends MongoGenDao<Member> {
    /**
     * 实现钩子方法,返回反射的类型
     *
     * @return
     */
    @Override
    protected Class<Member> getEntityClass() {
        return Member.class;
    }
}
