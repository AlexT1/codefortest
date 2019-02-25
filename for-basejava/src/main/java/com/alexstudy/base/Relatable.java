package com.alexstudy.base;

/**
 * @ClassName Relatable
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/24 16:17:18
 */
public interface Relatable {
    // this (object calling isLargerThan)
    // and other must be instances of
    // the same class returns 1, 0, -1
    // if this is greater than,
    // equal to, or less than other
    public int isLargerThan(Relatable other);
}
