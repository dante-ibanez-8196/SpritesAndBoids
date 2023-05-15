import javax.swing.*;
import java.awt.Image;

/**Explosion.java
 * A small java class to handle the explosion sprite (this is to be displayed when players collide)
 */
public class Explosion{
    //declare GLOBAL variables
    public int x_coordinate = 0;
    public int y_coordinate = 0;

    public Image explosionInfo;

    //constructor, load sprites
    public Explosion(){
        loadExplosion();
    }

    //get the image from the source
    public void loadExplosion(){
        ImageIcon explosionIcon = new ImageIcon("resources/explosion.gif");
        explosionInfo = explosionIcon.getImage();
    }

    //same getters from previous classes
    public int getX_coordinate(){
        return x_coordinate;
    }

    public int getY_coordinate(){
        return y_coordinate;
    }

    public Image explosionInfo(){
        return explosionInfo;
    }
}