package com.alexstudy.model;

import java.util.Date;

/**
 * @author AlexTong
 * @ClassName Member
 * @Description TODO()
 * @date 2018/1/17 15:51:22
 */
public class Member {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
