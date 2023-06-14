package labs.lab5.src;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> convertToUpperCaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> getUniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    public static int sumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (existingValue, newValue) -> newValue
                ));
    }

    public static void main(String[] args) {
        // Пример использования методов:
        List<Integer> numbersList = List.of(1, 2, 3, 4, 5, 5);
        System.out.println("Average: " + calculateAverage(numbersList));

        List<String> strings = List.of("cat", "dog", "pig", "rabbit", "parrot");
        System.out.println("Converted strings: " + convertToUpperCaseWithPrefix(strings));

        System.out.println("Unique squares: " + getUniqueSquares(numbersList));

        System.out.println("Filtered and sorted strings: " + filterAndSortStrings(strings, 'p'));

        List<String> emptyList = Collections.emptyList();
        try {
            System.out.println("Last element of strings: " + getLastElement(strings));
            System.out.println("Last element: " + getLastElement(emptyList));
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        int[] numbersArr1 = {2, 4, 5, 7};
        int[] numbersArr2 = {5, 7, 9, 11};
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers(numbersArr1));
        System.out.println("Sum of odd numbers: " + sumOfEvenNumbers(numbersArr2));

        System.out.println("Map: " + convertToMap(strings));
    }
}
