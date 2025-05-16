import java.util.Random;
import java.util.Scanner;

public class NumberGuessing{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int RANGE_MAX = 100;
        int targetNumber = random.nextInt(RANGE_MAX + 1);
        int attempts = 0;
        boolean isCorrect = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between 0 and " + RANGE_MAX + ". Try to guess it!");

        while (!isCorrect) {
            System.out.print("Enter your guess: ");
            
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess < 0 || guess > RANGE_MAX) {
                    System.out.println("Please enter a number between 0 and " + RANGE_MAX + ".");
                    continue;
                }

                if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    isCorrect = true;
                    System.out.printf("Congratulations! You guessed the number %d in %d attempts.%n", targetNumber, attempts);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}