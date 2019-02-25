package com.alexstudy.base;

/**
 * @ClassName AnimalInterface
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public interface AnimalInterface {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
