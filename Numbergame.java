import java.util.Scanner;
import java.util.Random;

public class Code 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean correctGuess = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess a number between 1 and 100.");

        while (!correctGuess) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                correctGuess = true;
            } else {
                int difference = Math.abs(guess - secretNumber);
                if (difference <= 5) {
                    System.out.println("You are very close!");
                } else if (difference <= 10) {
                    System.out.println("You are close!");
                } else if (difference <= 20) {
                    System.out.println("You are getting closer!");
                } else {
                    System.out.println("You are far!");
                }
            }
        }

        System.out.println("Number of attempts: " + attempts);
        int score = 100 - attempts;
        System.out.println("Your score: " + score);

        scanner.close();
    }
}
