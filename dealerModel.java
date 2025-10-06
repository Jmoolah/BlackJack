public class dealerModel extends baseModel {
    


   

    
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
    public String getName() {
        return name; // Get user's name
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
    
}