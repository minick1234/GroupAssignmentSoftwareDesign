/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Using this class to test code ideas
 *
 * @author cor_b
 */
public class Dealer {

   String suit; //The suit of the card (Ace, Hearts, etc)
   int value; //The value of the card, used for gameplay
   
   //This is the deck where the cards are stored
   Object[] deck = new Object[52];
   
   //This array is used to print the proper lable for the card
   String[] valueName = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
      "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
   
   //This is used to populate the deck in a random order
   ArrayList<Integer> cardNum = new ArrayList<Integer>();

   /**
    * Main method only used to test the program.
    * @param args 
    */
   public static void main(String[] args) {
      Dealer run = new Dealer();
      run.shuffleDeck();
   }

   /**
    * Empty constructor used as run object for main method
    */
   public Dealer() {
   }

   /**
    * The multiparameter object used for the card objects
    * @param suit  The suit of the card
    * @param value  The value of the card
    */
   public Dealer(String suit, int value) {
      this.suit = suit;
      this.value = value;
   }

   /**
    * This method will populate the cardNum ArrayList with 0-51, then through 
    * nested loops create each card in sequence. 
    * It will randomly pick a number from the ArrayList and assign each card 
    * to that position in the deck array, then remove that entry 
    * from the ArrayList.
    */
   public void shuffleDeck() {

      //Populate deck positions array, used to shuffle the cards.
      for (int i = 0; i < 52; i++) {
         cardNum.add(i);
      }

      //Populate the deck with randomly positioned cards.
      for (int suitNum = 0; suitNum <= 3; suitNum++) {
         //Each iteration of the parent loop represents one full suit
         if (suitNum == 0) {
            suit = "Hearts";
         } else if (suitNum == 1) {
            suit = "Spades";
         } else if (suitNum == 2) {
            suit = "Clubs";
         } else {
            suit = "Diamonds";
         }
         //Each iteration of the child loop represents one card in the suit
         for (int valueNum = 1; valueNum <= 13; valueNum++) {
            int deckLocation = (int) Math.floor(Math.random() * cardNum.size());
            
            //Place the card into the deck
            deck[cardNum.get(deckLocation)] = new Dealer(getSuit(), valueNum);
            cardNum.remove(deckLocation);
         }
      }
      //Print out the contents of the deck for testing purposes
      for (int a = 0; a < 52; a++) {
         System.out.println(deck[a]);
      }
   }

   /**
    * Return a string for the card suit
    * @return Returns the suit of the card (Ace, Hearts, etc)
    */
   public String getSuit() {
      return suit;
   }

   /**
    * Return a string for the card value
    * @return  Returns the value of the card as a string ("Ace", "Five", etc)
    */
   public String getValueName() {
      return valueName[value-1];
   }

   /**
    * Gets the string value and the suit of a card
    * @return Return print friendly card information
    */
   public String toString() {
      String printOut = getValueName() + " of " + getSuit();
      return printOut;
   }
}
