package eu.mithril.java.edu11;

public class StringProcessingMain {

    public static void main(String[] args) {
        // Test strings
        String[] testStrings = {
                "Hello World",
                "Java Programming",
                "Lambda Expressions"
        };

        // TODO: Create lambda for converting to uppercase
        StringProcessor toUpperCase = null; // implement

        // TODO: Create lambda for counting vowels
        // (should return string like "Vowels: 3")
        StringProcessor countVowels = null; // implement

        // TODO: Create lambda for removing spaces
        StringProcessor removeSpaces = null; // implement

        // TODO: Create lambda for adding exclamation mark at the end
        StringProcessor addExclamation = null; // implement

        // Process all strings with each processor
        System.out.println("Original Strings:");
        processStrings(testStrings, s -> s); // Identity processor

        System.out.println("\nUppercase:");
        processStrings(testStrings, toUpperCase);

        System.out.println("\nVowel Count:");
        processStrings(testStrings, countVowels);

        System.out.println("\nNo Spaces:");
        processStrings(testStrings, removeSpaces);

        System.out.println("\nWith Exclamation:");
        processStrings(testStrings, addExclamation);
    }

    private static void processStrings(String[] strings, StringProcessor processor) {
        for (String str : strings) {
            System.out.println(processor.process(str));
        }
    }
}

/*
 * Expected output example:
 *
 * Original Strings:
 * Hello World
 * Java Programming
 * Lambda Expressions
 *
 * Uppercase:
 * HELLO WORLD
 * JAVA PROGRAMMING
 * LAMBDA EXPRESSIONS
 *
 * Vowel Count:
 * Vowels: 3
 * Vowels: 4
 * Vowels: 4
 * Vowels: 5
 *
 * No Spaces:
 * HelloWorld
 * JavaProgramming
 * LambdaExpressions
 *
 * With Exclamation:
 * Hello World!
 * Java Programming!
 * Lambda Expressions!
 */