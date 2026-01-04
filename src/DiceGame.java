import java.util.Scanner;

public class DiceGame {

    private DiceSet dice = new DiceSet();
    private Player player = new Player();
    private Scanner scan = new Scanner(System.in);

    public void Start(){
        System.out.println("Welcome to the Dice Guessing Game");
        System.out.println("You start with 0 points and have 3 lifes" +
        "you have to secure 10 points to win before losing 3 lives");

        while (player.haslives() && !player.hasWon()) {
            playRoundOne ();
        }

        if (player.hasWon()) {
            System.out.println("congratulations! you won");
        }else {
            System.out.println("Sorry! You lost, Try again next time");
        }
    }

    private void playRoundOne () {

        int playerTotal = dice.rollTotal();
        int computerTotal = dice.rollTotal();

        String guess = askForGuess();

        if (playerTotal == computerTotal) {
            System.out.println("It`s a tie");
        } 
        else if (guessIsCorrect(guess, playerTotal, computerTotal)) {
          player.addPoints();
          System.out.println("Correct guess, You got 1 point");
        }
        else {
            player.loselive();
            System.out.println("Wrong guess, You lost 1 life");

        }
        showRoundInfo(playerTotal, computerTotal);
    }

    private String askForGuess() {
        String guess = "";
        while (!guess.equals("player") && !guess.equals("computer")) {
            System.out.println("Who has the higher total? (player/computer)");
            guess = scan.nextLine().toLowerCase();
        }
        return guess;
    }
    
    public boolean guessIsCorrect (String guess, int playerTotal, int computerTotal) {
        if (guess.equals("player") && playerTotal > computerTotal) {
            return true;
        } 
        if (guess.equals("computer") && computerTotal > playerTotal) {
            return true;
        }
        return false;
    }

    

    public static void main(String[] args) {
        
    }
}
