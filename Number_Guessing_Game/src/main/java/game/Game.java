package game;

import java.util.Random;
import java.util.Scanner;


public class Game {

    private final Difficulty difficulty;
    private final Scanner    scanner;
    private final Random     random;

    // ── Constructor ──────────────────────────────────────────────────────────
    public Game(Difficulty difficulty, Scanner scanner) {
        this.difficulty = difficulty;
        this.scanner    = scanner;
        this.random     = new Random();
    }

   
    public boolean play() {
        int maxNum      = difficulty.getMaxNumber();
        int maxAttempts = difficulty.getMaxAttempts();
        int secret      = random.nextInt(maxNum) + 1;   
        int hintLow  = 1;
        int hintHigh = maxNum;

        int     attemptsUsed = 0;
        boolean guessed      = false;

        System.out.printf("%n  ► A secret number has been chosen between 1 and %d.%n", maxNum);
        System.out.printf("  ► You have %d attempts. Good luck!%n%n", maxAttempts);

     
        while (attemptsUsed < maxAttempts) {

            displayProgressBar(attemptsUsed, maxAttempts);
            int guess = getValidGuess(hintLow, hintHigh);
            attemptsUsed++;

            
            if (guess < secret) {
                hintLow = guess + 1;                    
                int remaining = maxAttempts - attemptsUsed;
                if (remaining > 0) {
                    System.out.printf("  ↑  Too low!  Try between %d and %d.%n", hintLow, hintHigh);
                } else {
                    System.out.println("  ↑  Too low!");
                }

            } else if (guess > secret) {
                hintHigh = guess - 1;                   
                int remaining = maxAttempts - attemptsUsed;
                if (remaining > 0) {
                    System.out.printf("  ↓  Too high! Try between %d and %d.%n", hintLow, hintHigh);
                } else {
                    System.out.println("  ↓  Too high!");
                }

            } else {
                
                System.out.printf("%n  ★  Correct! The number was %d.%n", secret);
                System.out.printf("     You guessed it in %d attempt(s).%n", attemptsUsed);
                guessed = true;
                break;
            }
            
        }

        
        if (!guessed) {
            System.out.printf("%n  ✗  Out of attempts! The secret number was %d.%n", secret);
        }

        return guessed;
    }

  
    int getValidGuess(int low, int high) {
        while (true) {
            System.out.printf("%nYour guess (%d–%d): ", low, high);
            String input = scanner.nextLine().trim();
            try {
                int guess = Integer.parseInt(input);
                if (guess < low || guess > high) {
                    System.out.printf("  ✗  Number must be between %d and %d.%n", low, high);
                } else {
                    return guess;
                }
            } catch (NumberFormatException e) {
                System.out.println("  ✗  Please enter a whole number.");
            }
        }
    }

   
    void displayProgressBar(int used, int max) {
        int remaining = max - used;
        int pct       = (int) Math.round((double) remaining / max * 100);

        StringBuilder bar = new StringBuilder("  Attempts left: ");
        for (int i = 0; i < remaining; i++) bar.append('█');
        for (int i = 0; i < used;      i++) bar.append('░');
        bar.append(String.format("  (%d/%d  %d%%)", remaining, max, pct));

        System.out.println(bar);
    }
}
