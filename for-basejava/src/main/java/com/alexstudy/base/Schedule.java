package com.alexstudy.base;

import java.lang.annotation.Repeatable;

/**
 * @ClassName Schedule
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/24 14:21:15
 */
@Repeatable(Schedules.class)
public @interface Schedule {
    String dayOfMonth() default "first";
    String dayOfWeek() default "Mon";
    int hour() default 12;
}