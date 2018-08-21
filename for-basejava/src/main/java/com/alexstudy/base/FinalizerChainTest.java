package com.alexstudy.base;

import com.sun.jersey.server.impl.model.parameter.multivalued.StringReaderProviders;

/**
 * @author AlexTong
 * @ClassName FinalizerChainTest
 * @Description TODO()
 * @date 2018/7/17 16:13:20
 */
public class FinalizerChainTest {
    //Manual finalizer chaining
    protected void finalize() throws Throwable {
        try {
            //Finalize subclass state
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args){

    }
}
