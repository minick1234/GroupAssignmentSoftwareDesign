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
   Card card = new Card();
   Deck deck = new Deck();
   
   //This array is used to print the proper lable for the card
   String[] valueName = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
      "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
   
   //This is used to populate the deck in a random order
   ArrayList<Integer> cardNum = new ArrayList<>();

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
            int deckLocation = ((int) Math.floor(Math.random() * cardNum.size())); //Pick the deck location
            
            //Create card score (between 1 and 10)
            if (valueNum >= 10)
               value = 10;
            else
               value = valueNum;
            
            //Create the card object
            Card card = new Card(suit, valueName[valueNum-1], value);
            
            //Place the card into the deck
            deck.addCard(cardNum.get(deckLocation), card);
            cardNum.remove(deckLocation); //Remove option for filled position
         }
      }
      //Print out the contents of the deck for testing purposes
      System.out.println(deck);
   }
}
