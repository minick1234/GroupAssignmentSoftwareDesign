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
public class ThrowAwayClass {

   String suit;
   int value;
   Object[] deck = new Object[52];

   ArrayList<Integer> cardNum = new ArrayList<Integer>();

   public ThrowAwayClass(String suit, int value) {
      this.suit = suit;
      this.value = value;
   }

   public void shuffleCards() {
      //Populate deck positions
      for (int i = 0; i < 52; i++) {
         cardNum.add(i);
      }
      
      for (int i = 0; i < 52; i++) {
         /**
          * Using nested loops:
          * create 52 card objects: Ace - King of each suit
          * Then Math.random()cardNum.size() to pick a position in the deck array
          * Then remove the selected position from the cardNum array list
          * repeat until deck is built
          */
      }
   }
}
