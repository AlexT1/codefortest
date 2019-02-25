package com.alexstudy.base;

import com.alexstudy.util.FeeType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName ShadowTest
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/17 10:53:14
 */
public class ShadowTest {

    /**
     * nameOf,传入的参数name指的是枚举值的名称，一般是大写加下划线的
     * T
     * @param clazz
     * @param name
     * @return Enum T
     * @author   xiehao
     */
    public static <T extends Enum<T>> T nameOf(Class<T> clazz, String name) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(Enum.valueOf(clazz, name));
       System.out.println(Arrays.asList(clazz.getEnumConstants()));
       Map<String,String> cur = new HashMap<String,String>();

        System.out.println(clazz.getDeclaredField(name));
       System.out.println(clazz.getEnumConstants());
        return (T) Enum.valueOf(clazz, name);
    }

    public static <T extends Enum<T>> T getByStringTypeName(Class<T> clazz,String getTypeNameMethodName,String displayName, String typeName){
        T result = null;
        try{
            T[] arr = clazz.getEnumConstants();
            Method targetMethod = clazz.getDeclaredMethod(getTypeNameMethodName);
            Method displaymethod = clazz.getDeclaredMethod(displayName);
            String typeNameVal = null;
            String typeNameDisplay = null;
            for(T entity:arr){
                if (entity.name().equals(typeName)) {
                    typeNameDisplay = displaymethod.invoke(entity).toString();
                    typeNameVal = targetMethod.invoke(entity).toString();
                    System.out.println(typeNameDisplay + "    " + typeNameVal);
                    if(typeNameVal.contentEquals(typeName)){
                        result = entity;
                        break;
                    }
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T extends Enum<T>> String getDisplayNameByTypeName(Class<T> clazz,String getTypeNameMethodName,String displayName, String typeName){
        String result = null;
        try{
            T[] arr = clazz.getEnumConstants();
            Method targetMethod = clazz.getDeclaredMethod(getTypeNameMethodName);
            Method displaymethod = clazz.getDeclaredMethod(displayName);
            String typeNameVal = null;
            for(T entity:arr){
                typeNameVal = targetMethod.invoke(entity).toString();
                if (typeNameVal.contentEquals(typeName)) {

                        result = displaymethod.invoke(entity).toString();
                        return result;

                }
            }
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

        public int x = 0;

        class FirstLevel {

            public int x = 1;

            void methodInFirstLevel(int x) {
                System.out.println("x = " + x);
                System.out.println("this.x = " + this.x);
                System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            }
        }

        public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
            ShadowTest st = new ShadowTest();
            ShadowTest.FirstLevel fl = st.new FirstLevel();
            fl.methodInFirstLevel(23);
            String result = ShadowTest.getDisplayNameByTypeName(FeeType.class, "getValue","getDisplay", "8003");
            System.out.println(result);
        }
}
