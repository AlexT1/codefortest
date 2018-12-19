package com.alexstudy.base;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.Set;
import java.util.HashSet;
import java.time.chrono.IsoChronology;
/**
 * @ClassName MethodReferencesTest
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/18 14:39:05
 */
public class MethodReferencesTest {

    // The method transferElements copies elements from one collection to
    // another

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String... args) {

        List<PersonLambda> roster = PersonLambda.createRoster();

        for (PersonLambda p : roster) {
            p.printPerson();
        }


        PersonLambda[] rosterAsArray =
                roster.toArray(new PersonLambda[roster.size()]);

        class PersonAgeComparator implements Comparator<PersonLambda> {
            public int compare(PersonLambda a, PersonLambda b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray,
                (PersonLambda a, PersonLambda b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );
//        Arrays.sort(rosterAsArray,
//        (a, b) -> PersonLambda.compareByAge(a, b)
//      );

        // With method reference
        Arrays.sort(rosterAsArray, PersonLambda::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(PersonLambda a,
                                     PersonLambda b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(PersonLambda a,
                                    PersonLambda b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<PersonLambda> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });

        Set<PersonLambda> rosterSet = transferElements(roster, HashSet::new);
        //Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
    }
}
