package com.alexstudy.base;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author AlexTong
 * @ClassName Person
 * @Description TODO()
 * @date 2018/7/17 11:07:06
 */
public class Person {
    private final Date birthDate;
    //Other fields omitted
    public Person(Date birthDate){
        this.birthDate = birthDate;
    }

    //Don't do this, every call time will renew object
    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }
}

class Person1{
    private final Date birthDate;

    public Person1(Date birthDate){
        this.birthDate = birthDate;
    }

    /**
     *  The starting and ending dates of the baby boom.
    */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}
