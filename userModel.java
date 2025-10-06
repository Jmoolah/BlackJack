public class userModel extends baseModel {
    // User model for the game
    @SuppressWarnings("unused")
    private double balance; // User's balanceq


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
    public String getName() {
        return name; // Get user's name
    }
    public void setUserScore(String card1, String card2) {
    int cardValue1 = cards.getCardValue(card1);
    int cardValue2 = cards.getCardValue(card2);
    this.score = cardValue1 + cardValue2; // Set score as the sum of card values
}

public static void main(String[] args) {
    userModel user = new userModel("Test Player");
    user.setUserScore("Ace", "King");
    System.out.println("User Name: " + user.getName());
    System.out.println("User Score: " + user.score);
}
    

    
}