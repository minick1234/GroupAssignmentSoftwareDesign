
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The controller for the game.
 *
 * @author Cory Bridgman
 */
public class Game {

   /**
    * The main method, Controller of the game
    * @param args 
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      boolean gameOver = false;
      boolean playerTurn;
      boolean dealerTurn;
      boolean bettingPhase;
      int bet;

      //The dealer shuffles the deck, deals the cards, and holds its own hand
      Dealer dealer = new Dealer();
      //The player is the user
      Player player = new Player();

      do {
         player.clearHand();
         dealer.clearHand();
         
         //set bet
         bettingPhase = true;
         while(bettingPhase){
            System.out.println("You have $" + player.getMoney() + ".\nPlease "
                    + "place your bet.");
            try{
               input = new Scanner(System.in); //Re initialize the scanner b/c errros
               bet = input.nextInt();
            }catch(Exception e){
               bet = -1;
            }
            if(bet > player.getMoney()){
               System.out.println("You can't bet money you don't have.");
            }else if (bet <= 0){
               System.out.println("Please bet a real value.");
            }else{
               player.setBetMoney(bet);
               bettingPhase = false;
            }
         }
         //reset turn loop booleans if game was already played
         playerTurn = true;
         dealerTurn = true;

         //Shuffle the deck 
         dealer.shuffleDeck();
         
         //initial deal
         for (int i = 0; i < 2; i++) {
            dealer.dealSelf();
            dealer.dealPlayer(player);
         }
         
         //check for Blackjack (Loop since Aces default value is 1)
         if(player.getHandScore() == 21){
            System.out.println("< || ~ BLACKJACK! ~ || >\nYou win $"
               + (int)Math.ceil(player.getBetMoney()*1.5));
            player.setMoney((int)Math.ceil(player.getBetMoney()*1.5));
            continue;
         }

         //if player starts with 2 aces
         if(player.getHandScore() > 21){
             player.checkAces();
         }
         //PLAYER TURN
         while (playerTurn) {
            //player hand
            System.out.println("\nThe dealer has:\n" + dealer.hiddenHand()
                    + "\n\nYou are holding:\n" + player + "\n");

            //player hit until stand, then dealer play and round ends
            playerTurn = player.hitStandQuit(dealer);
            player.checkAces(); //recheck ace score after every round
            if(player.getHandScore() >= 21){
               if(player.getHandScore() == 21){
                  System.out.println("Your hand score is 21!\n");
               }else{
                  System.out.println("You've gone over 21.\n");
               }
               playerTurn = false;
               break;
            }
         }

         System.out.println("\t- - - - - - -\nThe dealer reveals his hand.\n"
                 + dealer + "\n");

         //DEALER TURN
         while (dealerTurn) {
            dealer.checkAces();
            if(player.getHandScore() > 21){
               dealerTurn = false;
               break;
            }
            //dealer HIT until hand over 17 then stand
            if (dealer.getHandScore() < 17) {
               dealer.dealSelf();
               dealer.checkAces(); //check again before hand worth print
               System.out.println("His hand is now worth " + dealer.getHandScore());
            } else {
               dealerTurn = false;
            }
         }

         player.winOrLose(dealer);
         
         if(player.getMoney() <= 0){
            System.out.println("You are broke.");
            gameOver = true;
         }
         
         if (!gameOver) {
            gameOver = player.playAgain();
         }
      } while (!gameOver);
      
      player.gameOver();
   }
}
