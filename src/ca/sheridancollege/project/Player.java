
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The player class, which represents the user and handles: bets and money,
 * calls, win/lose conditions, play again or exit, and game over events.
 * @author Cory bridgman
 */
public class Player extends Hand {

   private Scanner input = new Scanner(System.in);
   private boolean closeLoop = false;
   private String hsq;
   private int money = 100;
   private int bet;

   /**
    * Get the current player money pool
    *
    * @return Returns the money variable
    */
   public int getMoney() {
      return money;
   }

   /**
    * Set the current money pool for wins or losses
    *
    * @param m The wins or losses
    */
   public void setMoney(int m) {
      money += m;
      bet = 0;
   }

   /**
    * Set the amount to be bet
    *
    * @param b The amount to be bet
    */
   public void setBetMoney(int b) {
      bet = b;
   }

   /**
    * Get the amount currently on the table
    *
    * @return Returns the bet variable
    */
   public int getBetMoney() {
      return bet;
   }

   /**
    * The method which handles the user decision to hit, stand, or quit
    *
    * @param dealer The dealer object, which deals cards to the player
    * @return Return playerTurn true or false to end the loop
    */
   public boolean hitStandQuit(Dealer dealer) {
      
      input = new Scanner(System.in);
      hsq = "";

      closeLoop = false;
      while (!closeLoop) {
         System.out.println("Please choose to \"Hit\", \"Double\", \"Stand\", "
                 + "or \"Quit\"");
         hsq = input.nextLine();

         if (hsq.trim().equalsIgnoreCase("hit")) { //draw a card
            dealer.dealPlayer(this);
            closeLoop = true;
         } else if(hsq.trim().equalsIgnoreCase("double")){ //draw a card and end turn
            dealer.dealPlayer(this);
            bet += bet;
            closeLoop = true;
            return false;
         }else if (hsq.trim().equalsIgnoreCase("stand")) { //end turn
            closeLoop = true;
            return false;
         } else if (hsq.trim().equalsIgnoreCase("quit")) { //quit game
            gameOver();
         } else if (hsq.trim().equals("") || hsq == null) {
            System.out.println("Enter something.");
         } else {
            System.out.println("Invalid selection");
         }
      }
      return true;
   }

   /**
    * Check the player hand for aces each turn, and allow them to set the value
    */
   @Override
   public void checkAces() {

      for (Card c : getHand()) {
         if (c.getValue().equalsIgnoreCase("Ace")) { //if 1 ok but 11 not
            if (getHandScore() > 21) {
               System.out.println("Your hand value is too high. The score of "
                       + "your " + c + " is set to 1");
               c.setAceScore("yes");
               System.out.println("Your new hand value is " + getHandScore());
            }
         }
      }
   }

   /**
    * Check win or lose conditions
    * @param dealer Import the dealer object to compare vs player
    */
   public void winOrLose(Dealer dealer) {

      //if dealer score > 21  & player score <= 21 - player win
      if (dealer.getHandScore() > 21 && getHandScore() <= 21) {
         System.out.println("Dealer is bust! Player wins!");
         setMoney(bet * 2);
      }
      //if player score == 21 && dealer score != 21 - player win
      else if (dealer.getHandScore() != 21 && getHandScore() == 21) {
         System.out.println("Player wins!");
         setMoney(bet * 2);
      }
      //if player score > 21 - dealer win
      else if (getHandScore() > 21) {
         System.out.println("Player bust! Dealer wins!");
         setMoney(-bet);
      }
      //if player == dealer score - tie
      else if (dealer.getHandScore() ==  getHandScore()) {
         System.out.println("Push! It's a Tie.");
         setMoney(0);
      }
      //if dealer > player but both under 22
      else if ((dealer.getHandScore() >  getHandScore()) && 
              dealer.getHandScore() < 22){
         System.out.println("Dealer wins!");
         setMoney(-bet);
      }
      //if player > dealer but both under 22
      else if(dealer.getHandScore() < getHandScore() && getHandScore() < 22){
         System.out.println("Player wins!");
         setMoney(bet*2);
      }else{
         System.out.println("ERROR: EXTRA SCENARIO ~~~~~~~~~~~~~~~~~~~~~~~~");  
      }
   }

   /**
    * User select if they want another round
    * @return Return true or false for another round
    */
   public boolean playAgain() {
      String in = "";
      System.out.println("You currently have $" + money);
      while (1 < 2) {
         input = new Scanner(System.in);
         System.out.println("Do you want to play another round? \"yes\" or \"no\"");
         in = input.nextLine();
         if (in.trim().equalsIgnoreCase("yes")) {
            return false;
         } else if (in.trim().equalsIgnoreCase("no")) {
            return true;
         } else {
            System.out.println("\nPlease enter a valid input.\n");
         }
      }
   }

   /**
    * Ends the game and prints out the final wallet balance.
    */
   public void gameOver() {
      System.out.println("You leave the tabel with $" + getMoney() + " ");
      System.exit(0);
   }

}
