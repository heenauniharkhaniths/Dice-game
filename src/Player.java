public class Player {

    private int points = 0;
    private int lives = 3;

    public void addPoints() {
        points++;
    }

    public void loselive() {
        lives--;
    }

    public int getPoints(){
        return points;
    }

    public int getLives(){
        return lives;
    }

    public boolean hasWon(){
        return points >= 5;
    }

    public boolean haslives(){
        return lives > 0;
    }
    
    public void reset() {
      points = 0;
      lives = 3;
    }
    
}
