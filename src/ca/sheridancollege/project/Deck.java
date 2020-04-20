/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class Deck
{
   String[] valueName = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
      "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
   String[] suit = {"Hearts", "Spades", "Diamonds", "Clubs"};
   
   
   Card[] deckOfCards = new Card[52];
   
   /**
    * Add a card to the deck
    * @param position The position to be added
    * @param card The card object
    */
   public void addCard(int position, Card card){
      deckOfCards[position] = card;
   }
   
   /**
    * Get card from the deck
    * @param position The position of the card
    * @return Return the card object
    */
   public Card getCard(int position){
      return deckOfCards[position];
   }
   
   /**
    * Print out the deck contents. Used for testing
    * @return String containing contents of deck
    */
   public String toString(){
      String deckContent = "";
      
      for (int a = 0; a < 52; a++) {
         deckContent += deckOfCards[a] + "\n";
      }
      return deckContent;
   }
   
   /**
    * Return the name value of a card: ("Ace", "Five", "Queen", etc)
    * @param n The index of the valueName array
    * @return Returns the string name
    */
   public String getName(int n){
      return valueName[n];
   }
   
   /**
    * Return the suit of the card
    * @param s The index of the suit array
    * @return Returns the string suit
    */
   public String getSuit(int s){
      return suit[s];
   }
   
}//end class
