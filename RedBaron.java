import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**RedBaron.java
 * A java class which includes the other sprite for the final.
 * Code structure similar to OddEye (OddEye will handle the map loading so this class is shorter)
 */

 public class RedBaron{
    //declare GLOBAL variables

    public int x_coordinateUpdater = 0;
    public int y_coordinateUpdater= 0;
    
    public Image RedBaronDOWN1info;
    //constructor (load sprites)

    public RedBaron(){
      loadRedBaron();
    }

    //include images of RedBaron
    public void loadRedBaron(){
      ImageIcon imageIcon = new ImageIcon("redBaron/RedBaronDOWN1.png");
      RedBaronDOWN1info = imageIcon.getImage();
    }

    //getters
    public int getX_coordinate(){
      return 0;
    }

    public int getY_coordinate(){
      return 0;
    }


    //NPC(?) behavior 
    //could be a multiplayer game or what not, purpose should be 2 sprites interacting
    public void keyPressed(KeyEvent e){
      int userKey = e.getKeyCode(); //should be randomized if NPC

      //ifs to see where coordinates are updated
      //MOVE by 1 (flag) at a time (UP RIGHT POS/ DOWN LEFT NEG)
      if(userKey == KeyEvent.VK_UP){
         y_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_DOWN){
         y_coordinateUpdater = 1;
      }
     else if(userKey == KeyEvent.VK_LEFT){
         x_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_RIGHT){
         x_coordinateUpdater = 1;
     }
     else{
         System.out.println("INVALID INPUT!");
     }
    }

    //key released
    public void keyReleased(KeyEvent e){
      int userKey = e.getKeyCode(); //should be randomized if NPC

      //ifs to see where coordinates are updated
      //MOVE by 1 (flag) at a time (UP RIGHT POS/ DOWN LEFT NEG)
      if(userKey == KeyEvent.VK_UP){
         y_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_DOWN){
         y_coordinateUpdater = 1;
      }
     else if(userKey == KeyEvent.VK_LEFT){
         x_coordinateUpdater = -1;
      }
     else if(userKey == KeyEvent.VK_RIGHT){
         x_coordinateUpdater = 1;
     }
     else{
         System.out.println("INVALID INPUT!");
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