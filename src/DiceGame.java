import java.util.Scanner;

public class DiceGame {

    final  DiceSet dice = new DiceSet();
    final  Player player = new Player();
    final  Scanner scan = new Scanner(System.in);

    public void Start(){
        System.out.println("Welcome to the Dice Guessing Game");
        System.out.println("You start with 0 points and have 3 lifes" +
        "you have to secure 10 points to win before losing 3 lives");

        boolean keepPlaying = true;
        
        while (keepPlaying){

            playGame();
            
            keepPlaying = askToContinue();

            if (keepPlaying) {
             player.reset(); // Reset for next game
             System.out.println("\n Game restarted!\n");
            }

        }
        System.out.println("thanks for playing");
    }
        public void playGame() {
            while (player.haslives() && !player.hasWon()) {
              playRoundOne ();
            }

            if (player.hasWon()) {
              System.out.println("congratulations! you won");
            } else {
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
     
    public void showRoundInfo (int playerTotal, int computerTotal) {
        System.out.println("Player rolled: " + playerTotal);
        System.out.println("Computer rolled: " + computerTotal);
        System.out.println("Points: " + player.getPoints());
        System.out.println("Tries left: " + player.getLives());
        System.out.println("----------------------------------\n");
    }

    private boolean askToContinue() {
        String choice = "";
        while (!choice.equals("yes") && !choice.equals("no")) {
            System.out.println("Do you want to continue? (Yes/No)");
            choice = scan.nextLine().toLowerCase();
        }
        
        return choice.equals("yes");
    }

    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.Start();
    }
}
