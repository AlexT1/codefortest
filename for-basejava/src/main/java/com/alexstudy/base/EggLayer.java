package com.alexstudy.base;

/**
 * @ClassName EggLayer
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public interface EggLayer extends AnimalInterface {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}
