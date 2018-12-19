package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName MountainBike
 * @Description TODO()
 * @date 2018/9/11 15:37:30
 */
public class MountainBike extends Bicycle {
    // the MountainBike subclass has
    // one field
    public int seatHeight;

    // the MountainBike subclass has
    // one constructor
    public MountainBike(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}
