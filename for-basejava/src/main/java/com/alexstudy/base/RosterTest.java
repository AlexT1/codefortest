package com.alexstudy.base;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import java.lang.Iterable;
import java.time.chrono.IsoChronology;
/**
 * @ClassName RosterTest
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/17 15:42:29
 */
public class RosterTest {
    interface CheckPerson {
        boolean test(PersonLambda p);
    }

    // Approach 1: Create Methods that Search for Persons that Match One
    // Characteristic

    public static void printPersonsOlderThan(List<PersonLambda> roster, int age) {
        for (PersonLambda p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods

    public static void printPersonsWithinAgeRange(
            List<PersonLambda> roster, int low, int high) {
        for (PersonLambda p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression

    public static void printPersons(
            List<PersonLambda> roster, CheckPerson tester) {
        for (PersonLambda p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions

    public static void printPersonsWithPredicate(List<PersonLambda> roster, Predicate<PersonLambda> tester) {
        for (PersonLambda p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application

    public static void processPersons(List<PersonLambda> roster, Predicate<PersonLambda> tester,
            Consumer<PersonLambda> block) {
        for (PersonLambda p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    // Approach 7, second example

    public static void processPersonsWithFunction(List<PersonLambda> roster, Predicate<PersonLambda> tester,
            Function<PersonLambda, String> mapper, Consumer<String> block) {
        for (PersonLambda p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    // Approach 8: Use Generics More Extensively

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
            Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String... args) {

        List<PersonLambda> roster = PersonLambda.createRoster();

        for (PersonLambda p : roster) {
            p.printPerson();
        }

        // Approach 1: Create Methods that Search for Persons that Match One
        // Characteristic

        System.out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Approach 2: Create More Generalized Search Methods

        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        // Approach 3: Specify Search Criteria Code in a Local Class

        System.out.println("Persons who are eligible for Selective Service:");

        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            public boolean test(PersonLambda p) {
                return p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }

        printPersons(
                roster, new CheckPersonEligibleForSelectiveService());


        System.out.println();

        // Approach 4: Specify Search Criteria Code in an Anonymous Class

        System.out.println("Persons who are eligible for Selective Service " +
                "(anonymous class):");

        printPersons(
                roster,
                new CheckPerson() {
                    public boolean test(PersonLambda p) {
                        return p.getGender() == PersonLambda.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );

        System.out.println();

        // Approach 5: Specify Search Criteria Code with a Lambda Expression

        System.out.println("Persons who are eligible for Selective Service " +
                "(lambda expression):");

        printPersons(
                roster,
                (PersonLambda p) -> p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

        System.out.println();

        // Approach 6: Use Standard Functional Interfaces with Lambda
        // Expressions

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate parameter):");

        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

        System.out.println();

        // Approach 7: Use Lamba Expressions Throughout Your Application

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate and Consumer parameters):");

        processPersons(
                roster,
                p -> p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );

        System.out.println();

        // Approach 7, second example

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate, Function, and Consumer parameters):");

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        System.out.println();

        // Approach 8: Use Generics More Extensively

        System.out.println("Persons who are eligible for Selective Service " +
                "(generic version):");

        processElements(
                roster,
                p -> p.getGender() == PersonLambda.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        System.out.println();

        // Approach 9: Use Bulk Data Operations That Accept Lambda Expressions
        // as Parameters

        System.out.println("Persons who are eligible for Selective Service " +
                "(with bulk data operations):");

        roster
                .stream()
                .filter(
                        p -> p.getGender() == PersonLambda.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }
}
