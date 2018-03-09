package com.alexstudy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author AlexTong
 * @ClassName Hello
 * @Description TODO()
 * @date 2018/2/7 18:02:14
 */
public class Hello {
        public static void main(String[] args) {
            int[] r = new int[args.length];
            System.out.println(r.length);
            String a = "|";
            String ua = stringToUnicode(a);
            System.out.println(ua);
            String oa = "丨";
            String uoa = stringToUnicode(oa);
            System.out.println(uoa);
        /*获取本类的全部属性*/
            Class<?> demo = null;
         /* try {
            demo=Class.forName("reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */
            // demo=Demo.class;
            demo=new Demo().getClass();
            //获取某个类所声明的字x段(包括public、private、protected)
            Field[] field=demo.getDeclaredFields();
            for(int i=0;i<field.length;i++){
                //返回修饰符的编码
                int mo=field[i].getModifiers();
                //获取修饰符名称
                String decorate= Modifier.toString(mo);
                //输出修饰符名称
                System.out.println(decorate);
                //获取属性类型
                Class<?> type=field[i].getType();
                //输出属性类型
                System.out.println(type);
                //获取属性名称
                System.out.println(field[i].getName());

                //如果要获取其自身的属性和其父类或者接口的属性，用
                //Field[] field=demo.getFields();这个方法
            }
        }
    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += s.charAt(i) + ": " + "\\u" + Integer.toHexString(ch)
                        + "\n";
            else
                str += s.charAt(i) + ": " + "\\u00" + Integer.toHexString(ch)
                        + "\n";
        }
        return str;
    }

    }
