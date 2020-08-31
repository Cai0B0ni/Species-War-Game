// Caio Boni
// 5/29/2018
// CSE 142
// TA: Amelia Shull
// Assignment #8.Vulture
//
//This class defines every aspect of the object Vulture will do when running 
// the CritterMain Class
//   - always appear black
//   - eats if hungry
//   - roars v.s "%" otherwise pounces
//   - display as "V,<,>,^" dependent on direction it last moved 
//   - moves north,west,south,east (3x each)

import java.awt.*;

public class Vulture extends Bird { 
   //Provides if a vulture is or isnt hungry
   private boolean hunger; 
   
   //creaters instance of vulture in which it always starts out hungry
   public Vulture(){
      hunger = true;
   }

   // return the color the vulture should appear (always black)
   public Color getColor() {
      return Color.BLACK;
   }
   
   // returns whether or not the vulture should eat (dependent on hunger)
   public boolean eat() {
      if(hunger){
         hunger = false; 
         return true;
      }else{
         return false;
      }
   }
   
   // returns the attack a vulture should use when fighting and becomes hungry
   //  (always roars V.S "%" opponents otherwise it pounces)
   // Parameters:
   //  <opponent> when encountering an opponent the critter will behave a certain way 
   public Attack fight(String opponent) {
      hunger = true; 
      return super.fight(opponent);
   }
}