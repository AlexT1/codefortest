package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName BicycleApi
 * @Description TODO()
 * @date 2018/8/27 11:18:30
 */
public interface BicycleApi {
    //  wheel revolutions per minute
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}
