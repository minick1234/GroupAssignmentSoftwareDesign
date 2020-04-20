
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The Dealer handles shuffling the deck, dealing cards,
 * and plays against the player.
 * @author Cory Bridgman
 */
public class Dealer extends Hand {

   private String suit; //The suit of the card (Ace, Hearts, etc)
   private int value; //The value of the card, used for gameplay
   private int cardpos;

   //This is the deck where the cards are stored
   private Card card = new Card();
   private Deck deck = new Deck();

   //This is used to populate the deck in a random order
   private ArrayList<Integer> cardNum = new ArrayList<>();

   /**
    * Dealer draws a card
    */
   public void dealSelf() {
      if (getHand().size() >= 1) {
         System.out.println("The dealer draws a " + deck.getCard(cardpos));
      }
      addCard(deck.getCard(cardpos));
      cardpos++;
   }

   /**
    * Dealer adds a card to the player hand
    *
    * @param player The user, you
    */
   public void dealPlayer(Player player) {
      System.out.println("You are dealt a " + deck.getCard(cardpos));
      player.addCard(deck.getCard(cardpos));
      cardpos++;
   }

   /**
    * Populate the deck with Card objects.
    */
   public void shuffleDeck() {

      cardpos = 0; //set draw card position to "top of deck"
      
      //Populate deck positions array, used to shuffle the cards.
      for (int i = 0; i < 52; i++) {
         cardNum.add(i);
      }

      //Populate the deck with randomly positioned cards.
      for (int suitNum = 0; suitNum <= 3; suitNum++) {
         //Each iteration of the parent loop represents one full suit
         suit = deck.getSuit(suitNum);

         //Each iteration of the child loop represents one card in the suit
         for (int valueNum = 1; valueNum <= 13; valueNum++) {
            int deckLocation = ((int) Math.floor(Math.random() * cardNum.size())); //Pick the deck location

            //Create card score (between 1 and 10)
            if (valueNum >= 10) {
               value = 10;
            } else {
               value = valueNum;
            }

            //if Ace set value to 11
            if (deck.getName(valueNum - 1).equalsIgnoreCase("Ace")) {
               value = 11;
            }
            //Create the card object
            Card card = new Card(suit, deck.getName(valueNum - 1), value);

            //Place the card into the deck
            deck.addCard(cardNum.get(deckLocation), card);
            cardNum.remove(deckLocation); //Remove option for filled position
         }
      }
   }

   /**
    * Check the dealer hand for aces and set the value to 1 or 11 as needed.
    */
   @Override
   public void checkAces() {
      if (getHandScore() == 21) {
         return;
      }
      
      for(Card c: getHand()){
         if((c.getValue().equalsIgnoreCase("Ace")) && (c.getScore() != 1)){
            System.out.println("/// checking ace ///"); //////////////////////////////
          if(getHandScore() > 21){
             c.setAceScore("yes");
             System.out.println("The dealers hand value is too high, his "
             + c + " value has been set to 1.");
             System.out.println("The deals hand is now worth " + getHandScore());
          }
         }
      }
   }

   /**
    * Print the contents of the dealers hand
    *
    * @return The name and score of all visible cards
    */
   public String hiddenHand() {
      String holding = "A FACE DOWN card\n";
      for (int i = 1; i < getHand().size(); i++) {
         holding += getHand().get(i) + "\n";
      }
      holding += "Totaling: " + (getHandScore() - getHand().get(0).getScore())
              + " + the FACE DOWN card.";

      return holding;
   }
}
