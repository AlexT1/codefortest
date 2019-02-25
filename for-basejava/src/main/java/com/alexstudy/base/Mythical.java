package com.alexstudy.base;

/**
 * @ClassName Mythical
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}
