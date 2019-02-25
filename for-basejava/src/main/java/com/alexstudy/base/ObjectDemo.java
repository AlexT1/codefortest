package com.alexstudy.base;

/**
 * @ClassName Object
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/11/26 15:33:30
 */
public class ObjectDemo {
        // Has no fields
        // Has several methods, not shown...
}
class Liquid {
    private int mlVolume;
    private float temperature; // in Celsius
    public Liquid() {
        mlVolume = 300;
        temperature = (float) (Math.random() * 100.0);
    }
    public float getTemperature() {
        return temperature;
    }
    // Has several other methods, not shown...
}
// In source packet in file init/ex15/Coffee.java
class Coffee extends Liquid {
    private static final float BOILING_POINT = 100.0f; // Celsius
    private boolean swirling;
    private boolean clockwise;
    public Coffee(boolean swirling, boolean clockwise) {
        if (getTemperature() >= BOILING_POINT) {
            // Leave swirling at default value: false
            return;
        }
        this.swirling = swirling;
        if (swirling) {
            this.clockwise = clockwise;
        } // else, leave clockwise at default value: false
    }
    // Has several methods, not shown,
    // but doesn't override getTemperature()...
}

