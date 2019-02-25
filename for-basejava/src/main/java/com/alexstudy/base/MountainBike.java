package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName MountainBike
 * @Description TODO()
 * @date 2018/9/11 15:37:30
 */
public class MountainBike extends Bicycle {
    // the MountainBike subclass has one field
    public int seatHeight;
    private String suspension;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }
    // the MountainBike subclass has one constructor
    public MountainBike(int startCadence, int startSpeed, int startGear,  String suspensionType) {
        super(startCadence, startSpeed, startGear);
        this.setSuspension(suspensionType);
    }
    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    // the MountainBike subclass has one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" +
                getSuspension() + " suspension.");
    }
}
