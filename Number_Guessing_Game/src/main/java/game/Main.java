package game;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScoreTracker scores = new ScoreTracker();

        printBanner();

        boolean playAgain = true;

        while (playAgain) {
            Difficulty difficulty = chooseDifficulty(scanner);
            Game game = new Game(difficulty, scanner);
            boolean won = game.play();
            scores.record(won);
            scores.display();

            System.out.println("\nPlay again?");
            System.out.print("  [Y] Yes   [N] No   → ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("y") || answer.equals("yes");
        }

        System.out.println("\n  Thanks for playing! Goodbye.\n");
        scanner.close();
    }

    
    private static void printBanner() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("=".repeat(50));
    }

   
    private static Difficulty chooseDifficulty(Scanner scanner) {
        Difficulty[] options = Difficulty.values();

        System.out.println("\nChoose difficulty:");
        for (int i = 0; i < options.length; i++) {
            Difficulty d = options[i];
            System.out.printf("  [%d] %-8s (1–%d, %d attempts)%n",
                    i + 1, d.getName(), d.getMaxNumber(), d.getMaxAttempts());
        }

        while (true) {
            System.out.print("\nEnter choice (1-" + options.length + "): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= options.length) {
                    return options[choice - 1];
                }
            } catch (NumberFormatException ignored) { }
            System.out.println("  Invalid choice. Please enter a number between 1 and " + options.length + ".");
        }
    }
}
