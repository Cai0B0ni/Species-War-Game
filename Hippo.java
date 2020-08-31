// Caio Boni
// 5/29/2018
// CSE 142
// TA: Amelia Shull
// Assignment #8.Hippo
//
//This class defines every aspect of the object Hippo will do when running 
// the CritterMain Class
//   - color dependent on hunger(gray = hungry, else white)
//   - eats if hunger counter is non-zero
//   - scratches when hunger counter is non-zero, pounces otherwise
//   - display as the hunger counter 
//   - moves in a random direction 5 times

import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   //This is the hunger level that a hippo will have
   private int hunger;
   //Counter of how many moves has been done by a hippo
   private int move;
   //The direction in which the hippo will be taking
   private int direction;
   //Used to randomly provide a new direction for the hippo
   private Random r;
   
   //Creates new instance of the hippo given how hungry he is
   // Parameter:
   //   <hunger> determines how hungry it is
   public Hippo(int hunger) {
      r = new Random();
      this.hunger = hunger;
   }
   
   // return the color the hippo should appear 
   //  (when hungry it appears as gray, otherwise white)
   public Color getColor() {
      if(hunger != 0){
         return Color.GRAY;
      }else{
         return Color.WHITE;
      }
   }
   
   // returns whether or not the hippo should eat (dependent on hunger counter)
   public boolean eat() {
      if(hunger != 0){
         hunger--;
         return true;
      }else{
         return false;
      }
   }
   
   // returns the string representation of the hippo 
   //  (whatever the hunger counter is set to)
   public String toString() {
      return "" + hunger;
   }
   
   // returns the direction the hippo should move
   //   (randomly selects a move in which it will repeat it for 5 times and
   //     selects another and repeats the cycle)
   public Direction getMove() {      
      if(move % 5 == 0){
          // randomly selects an int from 0 to 3 inclusive, in which it is connected
          //  to a specific movement
          this.direction = r.nextInt(4); 
      }
      move++;
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
         
   // returns the attack a hippo should use when fighting (dependent on hunger)
   // Parameters:
   //  <opponent> when encountering an opponent the critter will behave a certain way 
   public Attack fight(String opponent) {
      if (hunger != 0){       // when hungry it scratches
         return Attack.SCRATCH;
      }else{                  // when full it pounces
          return Attack.POUNCE;
      }
   }
}