/**
 * SYST17796 Blackjack Card class
 * Deliverable 1
 */
package ca.sheridancollege.project;

/**
 * The card class is sued to create the card objects
 * They contain the suit, value, and score.
 * 
 * @author Cory Bridgman
 */
public class Card 
{
   private String suit; //The suit of the card (Hearts, clubs...)
   private String value; //The value of the card (Ace, Eight...)
   private int score; //The score of the card (1, 2, 10...)
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
   public Card(){}
   
   public Card(String suit, String value, int score){
      this.suit = suit;
      this.value = value;
      this.score = score;
   }
   
   public String getSuit(){
      return suit;
   }
   
   public String getValue(){
      return value;
   }
   
   public int getScore(){
      return score;
   }
   
    @Override
    public String toString(){
       String cardInfo = getSuit() + " of " + getValue();
       return cardInfo;
    }
    
}
