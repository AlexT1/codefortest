package com.alexstudy.base;

/**
 * @ClassName Flyer
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}
