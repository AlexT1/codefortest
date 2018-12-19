package com.alexstudy.base;

import org.omg.CORBA.Environment;

/**
 * @author AlexTong
 * @ClassName Bicycle
 * @Description TODO()
 * @date 2018/8/24 15:58:52
 */
public class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void changeCadence(int newValue) {
        cadence = newValue;
    }

    void changeGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println("cadence:" +
                cadence + " speed:" +
                speed + " gear:" + gear);
    }

    // the Bicycle class has
   // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

//    public Bicycle seeWhosFastest(Bicycle myBike, Bicycle yourBike,
//                                  Environment env) {
//        Bicycle fastest;
//        // code to calculate which bike is
//        // faster, given each bike's gear
//        // and cadence and given the
//        // environment (terrain and wind)
//        return fastest;
//    }

// use static modifier to share class variable and use it global
//    private int cadence;
//    private int gear;
//    private int speed;
//    private int id;
//    private static int numberOfBicycles = 0;
//
//    public Bicycle(int startCadence, int startSpeed, int startGear){
//        gear = startGear;
//        cadence = startCadence;
//        speed = startSpeed;
//
//        // increment number of Bicycles
//        // and assign ID number
//        id = ++numberOfBicycles;
//    }
//
//    // new method to return the ID instance variable
//    public int getID() {
//        return id;
//    }
}

//class Bicycle {
//
//    // the Bicycle class has
//    // three fields
//    public int cadence;
//    public int gear;
//    public int speed;
//
//    // the Bicycle class has
//    // one constructor
//    public Bicycle(int startCadence, int startSpeed, int startGear) {
//        gear = startGear;
//        cadence = startCadence;
//        speed = startSpeed;
//    }
//
//    // the Bicycle class has
//    // four methods
//    public void setCadence(int newValue) {
//        cadence = newValue;
//    }
//
//    public void setGear(int newValue) {
//        gear = newValue;
//    }
//
//    public void applyBrake(int decrement) {
//        speed -= decrement;
//    }
//
//    public void speedUp(int increment) {
//        speed += increment;
//    }
//}

//public class Bicycle {
//
//    private int cadence;
//    private int gear;
//    private int speed;
//
//    private int id;
//
//    private static int numberOfBicycles = 0;
//
//
//    public Bicycle(int startCadence,
//                   int startSpeed,
//                   int startGear) {
//        gear = startGear;
//        cadence = startCadence;
//        speed = startSpeed;
//
//        id = ++numberOfBicycles;
//    }
//
//    public int getID() {
//        return id;
//    }
//
//    public static int getNumberOfBicycles() {
//        return numberOfBicycles;
//    }
//
//    public int getCadence() {
//        return cadence;
//    }
//
//    public void setCadence(int newValue) {
//        cadence = newValue;
//    }
//
//    public int getGear() {
//        return gear;
//    }
//
//    public void setGear(int newValue) {
//        gear = newValue;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void applyBrake(int decrement) {
//        speed -= decrement;
//    }
//
//    public void speedUp(int increment) {
//        speed += increment;
//    }
//}