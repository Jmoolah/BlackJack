

public class cards{
    // Example card values and suits
    public static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};//11
    public static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};//3

    // Method to get card value based on the card name
    public static int getCardValue(String card) {
        return switch (card) {
            case "Ace" -> 11;
            case "King", "Queen", "Jack" -> 10;
            default -> Integer.parseInt(card);
        }; // Ace can be 1 or 11, simplified here
        // Face cards are worth 10
        // Numeric cards return their value
    }
}