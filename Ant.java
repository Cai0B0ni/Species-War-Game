// Caio Boni
// 5/29/2018
// CSE 142
// TA: Amelia Shull
// Assignment #8.Ant
//
//This class defines every aspect of the object Ant will do when running 
// the CritterMain Class
//   - always appear red
//   - always eat
//   - always scratches in fights
//   - display as "%" 
//   - either moves south-west or north-west

import java.awt.*;

public class Ant extends Critter {
   //Determine which direction it should walk
   private boolean walkSouth;
   //Tracks the how many moves it has done in a single game
   private int move;

   //Creates a new instance of the ant dependent on if it is to walk south or not
   // Parameter:
   //  <walksouth> determines whether the ant should walk south or not
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
   }
   
   // Return the color the ant should appear (always red)
   public Color getColor() {
      return Color.RED;
   }
   
   // Returns whether or not the ant should eat (always)
   public boolean eat() {
      return true;
   }
   
   // Returns the string representation of the ant
   public String toString() {
      return "%";
   }
   
   // returns the direction the ant should move
   //   (either south-west or north-west)
   public Direction getMove() {
      move++;
      if(walkSouth && move % 2 == 1){
      return Direction.SOUTH;
      } else if(!walkSouth && move % 2 == 1){
         return Direction.NORTH;
      }else{
         return Direction.WEST;
      }
   }
   
   // returns the attack an ant should use when fighting (always scratch)
   // Parameters:
   //  <opponent> when encountering an opponent the critter will behave a certain way 
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
}