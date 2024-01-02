// Certainly! Here's a simple text-based guessing game in Java where the user needs to guess a randomly generated number:

// ```java
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean hasGuessed = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I've picked a number between 1 and 100. Can you guess it?");

        while (!hasGuessed) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                hasGuessed = true;
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts!");
            } else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }

        scanner.close();
    }
}
// ```

// This game generates a random number between 1 and 100 and prompts the user to guess the number. It provides hints to the user to guess higher or lower based on their input and counts the number of attempts taken to guess the correct number.

// To play the game, copy this code into your Java IDE or a text editor, compile, and run the program. The user will be prompted to input their guesses until they correctly guess the randomly generated number.