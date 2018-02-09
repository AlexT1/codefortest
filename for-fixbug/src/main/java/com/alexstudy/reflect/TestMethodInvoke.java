package com.alexstudy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author AlexTong
 * @ClassName TestMethodInvoke
 * @Description TODO()
 * @date 2018/2/8 16:11:58
 */
public class TestMethodInvoke {
    public static void main(String[] args) {
        String [] names ={"tom","tim","allen","alice"};
        Class<?> clazz=hi.class;
        Method method = null;
        try {
            method=clazz.getMethod("sayHi", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
//        Method realMethod = serviceProcessor.getClass().getDeclaredMethod(methodName,JSONObject.class);
//
//        JSONObject paramJson =  (JSONObject) JSONObject.parse(param);
//
//        String data = ((String) realMethod.invoke(serviceProcessor, paramJson));
        for(String name:names){
            try {
                method.invoke(clazz.newInstance(), name);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
class hi{
    public void sayHi(String name){
        System.out.println("hi,"+name);
    }
}