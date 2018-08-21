package com.alexstudy.collectiontest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName Foo
 * @Description TODO()
 * @date 2018/7/16 17:36:08
 */
//Provider framework sketch
public abstract class Foo {
    //Maps String key to corresponding Class object
    private static Map implementations = null;

    //Initializes implementations map the first time it's called
    private static synchronized void initMapIfNecessary(){
        if (implementations == null) {
            implementations = new HashMap();
            //Load implementation class names and keys from
            //Properties file, translate names into Class
            //object using Class. forName and store mappings.

        }
    }
    public static Foo getInstance(String key){
        initMapIfNecessary();
        Class c = (Class) implementations.get(key);
        if (c == null)
            return new DefaultFoo();
        try {
            return (Foo) c.newInstance();
        } catch (Exception e){
            return new DefaultFoo();
        }
    }
}
