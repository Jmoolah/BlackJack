import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    
    
    public boolean isGameRunning = true;

    dealerModel dealer = new dealerModel();
    userModel user = new userModel();
    public Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    cards cards = new cards();
    boolean userContinue;


    public void runGame() {
        while (isGameRunning) {
            startGame();
        }
    }

    
    public void startGame() {

        System.out.println("Starting BlackJack game...");

        System.out.println();
        
        initailHnadS();
        printScore();
        sleep(5000);

        

        if(dealer.score == 21) {
            System.out.println("Dealer has a Blackjack! Dealer wins!");
            endGame();
            return;
        }
        
        System.out.println("Hit? (yes/no)");

        String UserContinue = scanner.nextLine();



        switch(UserContinue.toLowerCase()) {
            case "yes" -> userHit();
            case "no" -> {
                System.out.println("User chose to stop hitting.");
                dealerHit();
            }
            default -> {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
                break; // Exit the method if input is invalid
            }
        }

        
    }
       

        

public void initailHnadS(){
    
    int randomInt = rand.nextInt(11);  
    int randomInt1 = rand.nextInt(3); 
    System.out.println("Dealer's hand: " + cards.values[randomInt]+" of " + cards.suits[randomInt1]);
    int randomInt2 = rand.nextInt(11);  
    int randomInt3 = rand.nextInt(3); 
    
    int randomInt4 = rand.nextInt(11);  
    int randomInt5 = rand.nextInt(3); 
    System.out.println("User's hand: " + cards.values[randomInt2]+ " of " + cards.suits[randomInt3] + " and " + cards.values[randomInt4]+ " of " + cards.suits[randomInt5]);
    //user score
    user.setUserScore(cards.values[randomInt2], cards.values[randomInt4]);
    dealer.setDealerScore(cards.values[randomInt]);

}

public void userHit() {
    int randomInt = rand.nextInt(11);  
    int randomInt1 = rand.nextInt(3); 
    System.out.println("User hits: " + cards.values[randomInt] + " of " + cards.suits[randomInt1]);
    user.addScore(cards.getCardValue(cards.values[randomInt]));
    System.out.println("User's new score: " + user.score);
}

public void dealerHit() {
    int randomInt = rand.nextInt(11);  
    int randomInt1 = rand.nextInt(3); 
    System.out.println("Dealer hits: " + cards.values[randomInt] + " of " + cards.suits[randomInt1]);
    dealer.addScore(cards.getCardValue(cards.values[randomInt]));
    System.out.println("Dealer's new score: " + dealer.score);
}

public void printScore() {
    System.out.println("User Score: " + user.score);
    System.out.println("Dealer Score: " + dealer.score);
}

public void endGame() {
    System.out.println("Game Over!");
    double userBalance = user.getUserBalance();
    System.out.println("User's final balance: " + userBalance);
    
    isGameRunning = false;

}
@SuppressWarnings("CallToPrintStackTrace")
public void sleep(int milliseconds) {
    try {
        Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}