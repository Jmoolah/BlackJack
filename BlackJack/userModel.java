

import java.util.Random;
import java.util.Scanner;


    // User model for the game

public class userModel extends baseModel {


    private final Random rand = new Random();
    private final Scanner scanner = new Scanner(System.in);

   
    private double balance; 


    public double getUserBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public userModel() {
        this.score = 0; // Initialize score
        this.name = "Player"; // Default name
    }

    public userModel(String name) {
        this.score = 0; // Initialize score
        this.name = name; // Set user name
    }

    public void resetScore() {
        this.score = 0; // Reset score to zero
    }

    public void addScore(int points) {
        this.score += points; // Add points to the user's score
    }

    public void subtractScore(int points) {
        this.score -= points; // Subtract points from the user's score
    }

    
    public void setUserScore(String card1, String card2) {
    int cardValue1 = cards.getCardValue(card1);
    int cardValue2 = cards.getCardValue(card2);
    this.score = cardValue1 + cardValue2; // Set score as the sum of card values
}

  //checkingto see how the skip to next interracts
  // had to fix end game function
  public void testSetupScore(int x){
        this.score = x;
    }

    public void userHit() {
            //for hitting after initial flop 
            int randomInt = rand.nextInt(11);  
            int randomInt1 = rand.nextInt(3); 
            System.out.println("User hits: " + cards.values[randomInt] + " of " + cards.suits[randomInt1]);
            this.addScore(cards.getCardValue(cards.values[randomInt]));
            System.out.println("User's new score: " + this.score + "\n");
        }

    
    public void reHitUser(BlackJack bj) {
        String userInput = readYesNo("\nUser, do you want to hit again? (yes/no)");
        System.out.println();
        bj.sleep(2000);

        if (userInput.equals("yes")) {
            userHit();
            bj.sleep(2000);
        } else { // "no"
            System.out.println("User chose not to hit again.\n");
            bj.userContinueHitting = false;
        }

        if (this.score > 21) {
            this.setBalance(0);
            System.out.println("User busts! Dealer wins!");
            System.out.println("User final balance: " + this.getUserBalance());
            bj.userContinueHitting = false;
            bj.askEndgame();
        }
    }

    public void printUserScore(){
        System.out.println("User's current score: " + this.score);
    }

    public void getBetAmount(){
        System.out.println("How much money do you wish to bet?");
        while (!scanner.hasNextDouble()) {
             System.out.println("Invalid input. Please enter a number:");
            scanner.next(); // discard invalid input
}

        double userBalance = scanner.nextDouble();

        // Ensure it's greater than 0
        while (userBalance <= 0) {
            System.out.println("Please enter a valid amount greater than 0:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next();
            }
            userBalance = scanner.nextDouble();
            
        }

        scanner.nextLine(); // consume the newline
        System.out.println("Bet accepted: $" + userBalance + "\n");
        

        this.setBalance(userBalance);
    }

    public void checkUser_bust(BlackJack bj){
        if (this.score > 21) {
                System.out.println("User busts! Dealer wins!");
                System.out.println("User final balance: " + this.getUserBalance());
                bj.askEndgame();
                
            }  
    }
}