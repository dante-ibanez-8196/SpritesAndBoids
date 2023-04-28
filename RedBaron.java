import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**RedBaron.java
 * A java class which includes the other sprite for the final.
 * Code structure similar to OddEye
 */

 public class RedBaron{
    //declare GLOBAL variables

    public int x_coordinateUpdater = 0;
    public int y_coordinateUpdater= 0;
    

    //constructor (load sprites)
    public RedBaron(){

    }

    public void loadRedBaron(){

    }

    //getters
    public int getX_coordinate(){
      return 0;
    }

    public int getY_coordinate(){
      return 0;
    }

    //NPC(?) behavior 

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
    //getters for the images
 }