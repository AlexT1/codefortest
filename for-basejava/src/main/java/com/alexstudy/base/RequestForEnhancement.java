package com.alexstudy.base;

/**
 * @ClassName RequestForEnhancement
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/24 15:10:10
 */
/**
 * Describes the Request-for-Enhancement (RFE) annotation type.
 */
public @interface RequestForEnhancement {
    int id();
    String synopsis();
    String engineer() default "[unassigned]";
    String date() default "[unknown]";
}