/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author cor_b
 */
public abstract class Hand {
 
   private ArrayList<Card> hand = new ArrayList<>();
   
   /**
    * Add cards to the player or dealer hand
    * @param card The card to be added
    */
   public void addCard(Card card){
      hand.add(card);
   }
   
   /**
    * Get the entire hand, used for children who call variables directly
    * @return The ArrayList hand
    */
   public ArrayList<Card> getHand(){
      return hand;
   }
   
   /**
    * Get the total value of all cards in the players hands
    * @return Return the value of the hand
    */
   public int getHandScore(){
      int handScore = 0;
      for(int i = 0; i < hand.size(); i++){
         handScore += hand.get(i).getScore();
      }
      return handScore;
   }
   
   /**
    * Discard the hand
    */
   public void clearHand(){
      hand.clear();
      hand.trimToSize();
   }
   
   /**
    * Print out the contents of the hand
    * @return Return the hand contents
    */
   public String toString(){
      String holding = "";
      for(int i = 0; i < hand.size(); i++){
            holding += hand.get(i) + "\n";
      }
      holding += "Totaling: " + getHandScore();
      return holding;
   }
 
   
   
   /**
    * A placeholder method for the children to override.
    * Intended to check the hand for aces and adjust their values as needed
    */
   public abstract void checkAces();
}
