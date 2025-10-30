


public class BlackJack {
    
    
    
    

    private final dealerModel dealer = new dealerModel();
    private final userModel user = new userModel();
    private final baseModel bm = new baseModel();
    
    public  boolean isGameRunning = true;
   
    boolean userContinueHitting = true;
    boolean skipToNext;
    boolean firstGame = true;


    public void runGame() {
        while (isGameRunning) {
            startGame();
        }
    }

    public void startGame() {
        skipToNext = false;
        userContinueHitting = true;

        if (firstGame) {
            System.out.println("Welcome to BlackJack!!!\n");
            System.out.println("what is Your name: ");
            
            firstGame = false;
        } else {
            System.out.println("Starting a new game...\n");
        }
        
        sleep(1000);
        user.getBetAmount();
        sleep(1000);


        bm.initailHands(user, dealer);

        sleep(1000);

        bm.printScore(user, dealer);

        sleep(1000);//good

        bm.CheckForBlackJack(user, dealer, this);//good

        sleep(1000);
        

        user.checkUser_bust(this);
        
        while (userContinueHitting && !skipToNext) {
            
            user.reHitUser(this);
            sleep(1000);
        }
        while(!skipToNext && dealer.score <17 && dealer.score < user.score && dealer.score < 21 ){
            dealer.dealerHit();
            sleep(1000);
    }

    if(!skipToNext){
        bm.checkWinner(user, dealer, this);
        sleep(1000);
        System.out.println("User final balance: " + user.getUserBalance());
        sleep(1000);
        askEndgame(); 
        
    }   
    
    }

    public void endGame() {
        System.out.println("Game Over!");

        isGameRunning = false; // End the game loop
        skipToNext = true;
    }

    public void askEndgame() {
    String userInput = bm.readYesNo("Do you wish to play again? (yes/no)");
    sleep(1000);

    if (userInput.equals("yes")) {
        user.resetScore(); // Reset user score for a new game
        dealer.resetScore(); // Reset dealer score for a new game
        user.setBalance(0); // Reset user balance for a new game
        skipToNext = false; // Reset skipToNext for the new game
    } else { // userInput is "no"
        endGame();
    }
}

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

}



