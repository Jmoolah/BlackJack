

import java.util.Random;



public class dealerModel extends baseModel {
    
    private final Random rand = new Random();

    public dealerModel() {
        this.score = 0; // Initialize score
        this.name = "Player"; // Default name
    }
    public dealerModel(String name) {
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


   
    public void setDealerScore(String card1) {
        int cardValue1 = cards.getCardValue(card1);
    
        this.score = cardValue1; // Set score as the sum of card values
}

    public void setDealerScore(String card1, String card2) {
        int cardValue1 = cards.getCardValue(card1);
        int cardValue2 = cards.getCardValue(card2);
        this.score = cardValue1 + cardValue2; // Set score as the sum of card values
    }

    public void dealerHit() {
        int randomInt = rand.nextInt(11);  
        int randomInt1 = rand.nextInt(3); 
        System.out.println("Dealer hits: " + cards.values[randomInt] + " of " + cards.suits[randomInt1]);
        this.addScore(cards.getCardValue(cards.values[randomInt]));
        System.out.println("Dealer's new score: " + this.score + "\n");
    }


    public void DealercontinueHitting(BlackJack bj) {
        while (this.score < 17) {
            dealerHit();
            bj.sleep(2000);
        }
        if (this.score > 21) {
            System.out.println("Dealer busts! User wins!");
            bj.askEndgame();
        } else {
            System.out.println("Dealer stops hitting with a score of " + this.score);
            
        }
    }
    
}