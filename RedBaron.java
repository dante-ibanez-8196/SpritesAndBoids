import javax.swing.*;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**RedBaron.java
 * A java class which includes the other sprite for the final.
 * Code structure similar to OddEye (OddEye will handle the map loading so this class is shorter)
 */

 public class RedBaron{
    //declare GLOBAL variables
    //set begin coordinates as well
    public int x_coordinateUpdater = 0;
    public int y_coordinateUpdater= 0;
    public int x_coordinateFinalized = 100;
    public int y_coordinateFinalized = 100;
    
    public Image RedBaronDOWN1Info;
    //constructor (load sprites)

    public RedBaron(){
      loadRedBaron();
    }

    //include images of RedBaron
    public void loadRedBaron(){
      ImageIcon imageIcon = new ImageIcon("redBaron/RedBaronDOWN1.png");
      RedBaronDOWN1Info = imageIcon.getImage();
    }

    //getters
    public int getX_coordinate(){
      return x_coordinateFinalized;
    }

    public int getY_coordinate(){
      return y_coordinateFinalized;
    }

    public Image getRedBaronDOWN1Info(){
      return RedBaronDOWN1Info;
    }


    //control movement of 2nd player (WASD cluster)
    public void keyPressed(KeyEvent e){
      int userKey = e.getKeyCode(); //should be randomized if NPC

      //ifs to see where coordinates are updated
      //MOVE by 1 (flag) at a time (UP RIGHT POS/ DOWN LEFT NEG)
      if(userKey == KeyEvent.VK_W){
         y_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_S){
         y_coordinateUpdater = 1;
      }
     else if(userKey == KeyEvent.VK_A){
         x_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_D){
         x_coordinateUpdater = 1;
     }
     /*else{
         System.out.println("INVALID INPUT!");
     }*/
    }

    //key released
    public void keyReleased(KeyEvent e){
      int userKey = e.getKeyCode(); //should be randomized if NPC

      //ifs to see where coordinates are updated
      //MOVE by 1 (flag) at a time (UP RIGHT POS/ DOWN LEFT NEG)
      if(userKey == KeyEvent.VK_W){
         y_coordinateUpdater = 0;
      }
     else if(userKey == KeyEvent.VK_S){
         y_coordinateUpdater = 0;
      }
     else if(userKey == KeyEvent.VK_A){
         x_coordinateUpdater = 0;
      }
     else if(userKey == KeyEvent.VK_D){
         x_coordinateUpdater = 0;
     }

    }

    //method updates finalized coordinates with the updater ones
    /**
     * Update the coordinates taking into account the updaters results
     * to be called later in the WorldMap class
     */
    public void movePlayer(){
      //increment the finalized with the updater
      x_coordinateFinalized += x_coordinateUpdater;
      y_coordinateFinalized += y_coordinateUpdater;
  }

 }