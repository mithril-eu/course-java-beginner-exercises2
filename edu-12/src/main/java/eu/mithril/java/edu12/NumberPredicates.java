package eu.mithril.java.edu12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NumberPredicates {
    // TODO: Define reusable predicates as static fields
    private static final Predicate<Integer> IS_EVEN = num -> num % 2 == 0;

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12, 15, 20, 25
        );

        // TODO: Create and test predicates
        // 1. Filter even numbers
        // 2. Filter positive numbers
        // 3. Filter single digit numbers (0-9)
        // 4. Combine predicates using and()
        // 5. Combine predicates using or()
        // 6. Use negate()
        // 7. Create custom range predicate

        System.out.println("Original numbers: " + numbers);
        System.out.println("Even numbers: " + filterNumbers(numbers, IS_EVEN));
        // TODO: Add your predicate tests here

    }
}
/* Expected Output:
Original numbers: [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 20, 25]
Even numbers: [-4, -2, 0, 2, 4, 6, 8, 10, 12, 20]
Positive numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 20, 25]
Single digit numbers: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Even AND positive: [2, 4, 6, 8, 10, 12, 20]
Even OR single digit: [-4, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 20]
Not even numbers: [-5, -3, -1, 1, 3, 5, 7, 9, 11, 15, 25]
Numbers between 0 and 10: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Even positive numbers less than 20: [2, 4, 6, 8, 10, 12]
*/