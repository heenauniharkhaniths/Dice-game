import java.util.Scanner;

public class DiceGame {

    DiceSet dice = new DiceSet();
    Player player = new Player();
    Scanner scan = new Scanner(System.in);

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
    public static void main(String[] args) {
        
    }
}
