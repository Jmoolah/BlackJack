

import java.util.Random;
import java.util.Scanner;

class baseModel {

    private final Random rand = new Random();
    private final Scanner scanner = new Scanner(System.in);


    // Base model for the game
    protected int score; 
    protected String name;


    public void initailHands(userModel user, dealerModel dealer){
    
    int randomInt = rand.nextInt(11);  
    int randomInt1 = rand.nextInt(3); 
    System.out.println("Dealer's hand: " + cards.values[randomInt]+" of " + cards.suits[randomInt1]);
    int randomInt2 = rand.nextInt(11);  
    int randomInt3 = rand.nextInt(3); 
        
    int randomInt4 = rand.nextInt(11);  
    int randomInt5 = rand.nextInt(3); 
    System.out.println("User's hand: " + cards.values[randomInt2]+ " of " + cards.suits[randomInt3] + " and " + cards.values[randomInt4]+ " of " + cards.suits[randomInt5]+ "\n");
    //user score
    user.setUserScore(cards.values[randomInt2], cards.values[randomInt4]);
    dealer.setDealerScore(cards.values[randomInt]);

    }


    public void printScore(userModel user, dealerModel dealer ) {
    System.out.println("User Score: " + user.score);
    System.out.println("Dealer Score: " + dealer.score);

    }

    public void determineBalance_normalWin(userModel user) {
        double userBalance = user.getUserBalance();
        user.setBalance(userBalance*=2); 
    }

    public void detremnineBalance_Blackjack(userModel user){
            
        double userBalance = user.getUserBalance();
        user.setBalance(userBalance *2.5 ); 

    }

    public void checkWinner(userModel user, dealerModel dealer, BlackJack bj){
        if(dealer.score > 21){
            System.out.println("Dealer busts! User wins!");
            determineBalance_normalWin(user);
            bj.endGame();
            return;
        }

        int userScore = 21-user.score;
        int dealerScore = 21-dealer.score;
        if(userScore == dealerScore){
            System.out.println("It's a tie! Both user and dealer have the same score.");
        } 

        else if (userScore < dealerScore) {
            System.out.println("User wins with a score of " + user.score + " against dealer's score of " + dealer.score);
            determineBalance_normalWin(user);
        } 

        else {
            System.out.println("Dealer wins with a score of " + dealer.score + " against user's score of " + user.score);
            user.setBalance(0); // Reset user balance if dealer wins
        }
    }

    public String readYesNo(String prompt) {
        String input;
        while (true) {
        System.out.println(prompt);
        input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes") || input.equals("no")) {
            return input;
        }

        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }


    public void CheckForBlackJack(userModel user, dealerModel dealer,BlackJack bj) {
        if (user.score == 21 && dealer.score == 21) {
            System.out.println("Its a tie! Both user and dealer have Blackjack!");
            
            bj.askEndgame();
        } else if (dealer.score == 21) {
            System.out.println("Dealer has a Blackjack! Dealer wins!");
            
            bj.askEndgame();
            
        }
        else if (user.score == 21) {
            System.out.println("User has a Blackjack! User wins!");
            detremnineBalance_Blackjack(user);
            bj.askEndgame();
           
        }
    }


    


   
}
