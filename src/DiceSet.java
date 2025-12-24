
import java.util.Random;

public class DiceSet {

       private int sides = 6;
       private int count = 3;
       Random random = new Random();

       public int rollTotal() {
          int total = 0;
          for (int i = 0; i < count; i++){
          total += random.nextInt(sides) + 1;
        }
       return total;
    }    
}
