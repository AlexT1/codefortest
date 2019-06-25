package com.alexstudy.baseextend;

/**
 * @ClassName DataTypeDefaults
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/6/24
 */
public class DataTypeDefaults {
    byte byteValue;
    short shortValue;
    int intValue;
    long longValue;
    float floatValue;
    double doubleValue;
    char charValue;
    boolean booleanValue;
    String stringValue;

    public static void main(String[] args){
        DataTypeDefaults dtd = new DataTypeDefaults();
        String str1 = "hello\\sir34";
        String str2 = str1.replaceAll("\\d", "OK");
        System.out.println("hello\\sir" + "   " + str1 + " str2: " + str2);
        System.out.println("byte default value: " + dtd.byteValue);
        System.out.println("short default value: " + dtd.shortValue);
        System.out.println("int default value: " + dtd.intValue);
        System.out.println("long default value: " + dtd.longValue);
        System.out.println("float default value: " + dtd.floatValue);
        System.out.println("double default value: " + dtd.doubleValue);
        System.out.println("char default value: " + dtd.charValue+ "   " + '\u0000');
        System.out.println("boolean default value: " + dtd.booleanValue);
        System.out.println("String default value: " + dtd.stringValue);
    }
}
