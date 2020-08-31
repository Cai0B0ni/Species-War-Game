// Caio Boni
// 5/29/2018
// CSE 142
// TA: Amelia Shull
// Assignment #8.Bird
//
//This class defines every aspect of the object Bird will do when running 
// the CritterMain Class
//   - always appear blue
//   - never eats(default)
//   - roars v.s "%" otherwise pounces
//   - display as "V,<,>,^" dependent on direction it last moved 
//   - moves north,west,south,east (3x each)

import java.awt.*;

public class Bird extends Critter {
   //In order to determine what movement is to be taken next based on the move counter
   private int move;

   // return the color the bird should appear (always blue)
   public Color getColor() {
      return Color.BLUE;
   }
   
   // returns the string representation of the bird
   //  (dependent on last move)
   public String toString() {
      if(move <= 3 && move != 0){  // when moving north
         return "^";    
      }else if(move <= 6 && move != 0) {        // when moving east
         return ">";    
      }else if(move <= 9 && move != 0) {        // when moving south
         return "V";    
      }else {                      // when moving west
         return "<";    
      }
   }
   
   // returns the direction the bird should move
   //   (3x north, 3x east, 3x south, 3x west in that order)
   public Direction getMove() {
      move++;
      if(move <= 3){
         return Direction.NORTH;
      }else if(move <= 6) {
         return Direction.EAST;
      }else if(move <= 9) {
         return Direction.SOUTH;
      }else {
         if(move == 12){
            move = 0;
         }
         return Direction.WEST;
      }
   }
  
   // returns the attack a bird should use when fighting 
   //  (always roars V.S "%" opponents otherwise it pounces)
   // Parameters:
   //  <opponent> when encountering an opponent the critter will behave a certain way 
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
      }else{
         return Attack.POUNCE;
      }
   }
}