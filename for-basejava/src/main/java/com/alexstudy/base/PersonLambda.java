package com.alexstudy.base;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PersonLambda
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/17 15:14:46
 */
public class PersonLambda {

        public enum Sex {
            MALE, FEMALE
        }

        String name;
        LocalDate birthday;
        Sex gender;
        String emailAddress;

        PersonLambda(String nameArg, LocalDate birthdayArg,
               Sex genderArg, String emailArg) {
            name = nameArg;
            birthday = birthdayArg;
            gender = genderArg;
            emailAddress = emailArg;
        }

        public int getAge() {
            return birthday
                    .until(IsoChronology.INSTANCE.dateNow())
                    .getYears();
        }

        public void printPerson() {
            System.out.println(name + ", " + this.getAge());
        }

        public Sex getGender() {
            return gender;
        }

        public String getName() {
            return name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public static int compareByAge(PersonLambda a, PersonLambda b) {
            return a.birthday.compareTo(b.birthday);
        }

        public static List<PersonLambda> createRoster() {

            List<PersonLambda> roster = new ArrayList<>();
            roster.add(
                    new PersonLambda(
                            "Fred",
                            IsoChronology.INSTANCE.date(1980, 6, 20),
                            PersonLambda.Sex.MALE,
                            "fred@example.com"));
            roster.add(
                    new PersonLambda(
                            "Jane",
                            IsoChronology.INSTANCE.date(1990, 7, 15),
                            PersonLambda.Sex.FEMALE, "jane@example.com"));
            roster.add(
                    new PersonLambda(
                            "George",
                            IsoChronology.INSTANCE.date(1991, 8, 13),
                            PersonLambda.Sex.MALE, "george@example.com"));
            roster.add(
                    new PersonLambda(
                            "Bob",
                            IsoChronology.INSTANCE.date(2000, 9, 12),
                            PersonLambda.Sex.MALE, "bob@example.com"));

            return roster;
        }
}
