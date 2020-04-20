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
     * Default constructor
     */
   public Card(){}
   
   /**
    * Multiparameter constructor used to build the card object
    * @param suit The suit of the card
    * @param value The "name" of the card ("Two, Three, King, etc")
    * @param score The actual score value of the card
    */
   public Card(String suit, String value, int score){
      this.suit = suit;
      this.value = value;
      this.score = score;
   }
   
   /**
    * Gets the suit of the card
    * @return Returns the suit string
    */
   public String getSuit(){
      return suit;
   }
   
   /**
    * Change the score value of the Ace
    * @param v either 1 or 11
    */
   public boolean setAceScore(String v){
      if(v.trim().equalsIgnoreCase("no")){
         score = 11;
      }else if(v.trim().equalsIgnoreCase("yes")){
         score = 1;
      }else{
         System.out.print("Please select only \"yes\" or \"no\"");
         return false;
      }
      return true;
   }
   
   /**
    * Gets the value (name) of a card
    * @return Return the value variable
    */
   public String getValue(){
      return value;
   }
   
   /**
    * Gets the score of the card
    * @return Returns the score variable
    */
   public int getScore(){
      return score;
   }
   
   /**
    * Prints out the name and suit of the card
    * @return Returns the string for name and suit
    */
    @Override
    public String toString(){
       String cardInfo = getValue() + " of " + getSuit();
       return cardInfo;
    }
    
}
