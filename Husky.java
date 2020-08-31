// Caio Boni
// 5/29/2018
// CSE 142
// TA: Amelia Shull
// Assignment #8.Husky
//
//This class defines every aspect of the object Husky will do when running 
// the CritterMain Class

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   ///determine how many moves the critter has gone in the per game
   private int move;
   //deterine the direction of husky
   private int direction;
   // check to see if husky if sleepign
   private boolean sleeping;
   //check to see if husky is mating
   private boolean mating;
   
   // return the color the husky should appear (either blue or yellow)
   public Color getColor() {
      if(move % 2 == 0){   // every other moves it changes color (flashes)
         return Color.BLUE;
      }else{
         return Color.YELLOW;
      }
   }
   
   // turns value of sleeping to true while sleeping
   public void sleep() {
      sleeping = true;
   }
   
   // turns value of mating to true while mating
   public void mate() {
      mating = true;
   }

   // returns whether or not the husky should eat (always)
   public boolean eat() {
      return true;
   }
   
   // turns value of mating to false while mating
   public void mateEnd() {
      mating = false;
   }
   
   // turns value of sleeping to false while sleeping
	public void wakeup() {
      sleeping = false;
   }
      
   // Returns the string representation of the husky
   public String toString() {
      if(sleeping || mating){ // when sleeping/mating it camouflages as an empty space
         return " ";
      }else{
         return "%"; // camouflages itself as an ant 
      }
   }
   
   // Returns the direction the husky should move
   // (random direction every two moves unless next to food)
   public Direction getMove() {
      Random d = new Random();
      
      if(move % 2 == 0){
          this.direction = d.nextInt(2);
      }
      move++;
      // if there is food near the husky after 50 moves has passed it will move to it and eat
      if(move > 50){  
         if(getNeighbor(Direction.EAST).equals(".")){
            return Direction.EAST;
         }else if(getNeighbor(Direction.WEST).equals(".")){
            return Direction.WEST;
         }else if(getNeighbor(Direction.SOUTH).equals(".")){
            return Direction.SOUTH;
         }else if(getNeighbor(Direction.NORTH).equals(".")){
            return Direction.NORTH;
         }
      }
      if(direction == 0){ 
         return Direction.WEST;
      }else if(direction == 1){ 
         return Direction.NORTH;
      }else if(direction == 2){ 
         return Direction.SOUTH;
      }else{ 
         return Direction.EAST;
      }
   }
         
   // returns the attack the husky should use when fighting (dependent on opponent it encounters)
   public Attack fight(String opponent) {
      if(opponent.equals("V") || opponent.equals("<") || opponent.equals(">") || 
         opponent.equals("^")){
         return Attack.POUNCE;
      }else if(opponent.equals("0")){
         return Attack.SCRATCH;
      }else{
         return Attack.ROAR;
      }
   }
}