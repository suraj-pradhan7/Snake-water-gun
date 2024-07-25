import java.util.Random;
import java.util.Scanner;

public class SnakeWaterGunGame {
    // Global variables to store scores
    private static int playerScore = 0;
    private static int computerScore = 0;

    // Enum for choices
    enum Choice {
        SNAKE, WATER, GUN
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Main game loop
        while (true) {
            System.out.println("Enter your choice (Snake, Water, Gun) or type 'exit' to quit:");
            String playerInput = scanner.nextLine().trim().toUpperCase();

            if (playerInput.equals("EXIT")) {
                break;
            }

            Choice playerChoice;
            try {
                playerChoice = Choice.valueOf(playerInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice! Please enter Snake, Water, or Gun.");
                continue;
            }

            Choice computerChoice = Choice.values()[random.nextInt(Choice.values().length)];
            System.out.println("Computer chose: " + computerChoice);

            determineWinner(playerChoice, computerChoice);
            displayScores();
        }

        System.out.println("Final Scores:");
        displayScores();
        scanner.close();
    }

    private static void determineWinner(Choice playerChoice, Choice computerChoice) {
        if (playerChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if (
            (playerChoice == Choice.SNAKE && computerChoice == Choice.WATER) ||
            (playerChoice == Choice.WATER && computerChoice == Choice.GUN) ||
            (playerChoice == Choice.GUN && computerChoice == Choice.SNAKE)
        ) {
            System.out.println("You win this round!");
            playerScore++;
        } else {
            System.out.println("Computer wins this round!");
            computerScore++;
        }
    }

    private static void displayScores() {
        System.out.println("Player Score: " + playerScore + " | Computer Score: " + computerScore);
    }
}
