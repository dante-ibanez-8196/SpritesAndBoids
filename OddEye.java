import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**OddEye.java
 * A java class which includes the characteristics of the player, OddEye
 * Includes methods and attributes such as getters for certain data types
 */
public class OddEye {
    //declare GLOBAL variables within the class to contain info
    //the coordinates as well as the map data and collect Image info of background and sprite
    public int x_coordinateUpdater = 0;
    public int y_coordinateUpdater = 0;

    public int x_coordinateFinalized = 200;

    public int y_coordinateFinalized = 200;
    public int mapHeight = 0;
    public int mapWidth = 0;
    public Image backgroundImage, oddEyeDOWN1Info, oddEyeDOWN2Info, oddEyeLEFT1Info, oddEyeLEFT2Info, oddEyeRIGHT1Info, oddEyeRIGHT2Info, oddEyeUP1Info, oddEyeUP2Info;

    /**
     * OddEye constructor to call load the background and sprites
     */
    public OddEye(){
        loadBackgroundImage();
        loadOddEye();
    }

    /**
     * This method will load world.gif
     */
    public void loadBackgroundImage(){
        //load the game map and collect the info of world.gif
        ImageIcon imageIcon = new ImageIcon("gameBackground/world.gif");
        backgroundImage = imageIcon.getImage();

        //collect height and width info (observer is NULL)
        mapHeight = backgroundImage.getHeight(null);
        mapWidth = backgroundImage.getWidth(null);
    }

    /**
     * This method will load each of the oddeye sprites
     * Note that the OddEyeDOWN 1 and 2 variables will be the "idle" sprites
     */
    public void loadOddEye(){
        //declare ii for all images (8 in total)
        //INCLUDE FILE EXTENSIONS
        /*SPRITES*/
        ImageIcon oddEyeDOWN1 = new ImageIcon("oddEye/OddEyeDOWN1.png");
        ImageIcon oddEyeDOWN2 = new ImageIcon("oddEye/OddEyeDOWN2.png");
        ImageIcon oddEyeLEFT1 = new ImageIcon("oddEye/OddEyeLEFT1.png");
        ImageIcon oddEyeLEFT2 = new ImageIcon("oddEye/OddEyeLEFT2.png");
        ImageIcon oddEyeRIGHT1 = new ImageIcon("oddEye/OddEyeRIGHT1.png");
        ImageIcon oddEyeRIGHT2 = new ImageIcon("oddEye/OddEyeRIGHT2.png");
        ImageIcon oddEyeUP1 = new ImageIcon("oddEye/OddEyeUP1.png");
        ImageIcon oddEyeUP2 = new ImageIcon("oddEye/OddEyeUP2.png");


        oddEyeDOWN1Info = oddEyeDOWN1.getImage();
        oddEyeDOWN2Info = oddEyeDOWN2.getImage();
        oddEyeLEFT1Info = oddEyeLEFT1.getImage();
        oddEyeLEFT2Info = oddEyeLEFT2.getImage();
        oddEyeRIGHT1Info = oddEyeRIGHT1.getImage();
        oddEyeRIGHT2Info = oddEyeRIGHT2.getImage();
        oddEyeUP1Info = oddEyeUP1.getImage();
        oddEyeUP2Info = oddEyeUP2.getImage();

    }

    //declare getter methods that return the x and y coordinates of the player
    //code syntax identical with these, to be called later in move function
    //as one parameter can be returned in a method

    /**
     * Getter to get the updated x coordinate
     * @return the X updater
     */
    public int getX_coordinate(){
        return x_coordinateFinalized;
    }

    /**
     * Getter to get the updated y coordinate
     * @return the Y updater
     */
    public int getY_coordinate() {
        return y_coordinateFinalized;
    }

    public int getMapHeight(){
        return mapHeight;
    }

    public int getMapWidth(){
        return mapWidth;
    }

    //getters for each of the OddEye sprites to be called in WorldMap
    //can be all condensed to one line
    public Image returnBackgroundImage(){
        return backgroundImage;
    }

    public Image getOddEyeDOWN1Info() {
        return oddEyeDOWN1Info;
    }

    public Image getOddEyeDOWN2Info() {
        return oddEyeDOWN2Info;
    }

    public Image getOddEyeLEFT1Info() {
        return oddEyeLEFT1Info;
    }

    public Image getOddEyeLEFT2Info() {
        return oddEyeLEFT2Info;
    }

    public Image getOddEyeRIGHT1Info() {
        return oddEyeRIGHT1Info;
    }

    public Image getOddEyeRIGHT2Info() {
        return oddEyeRIGHT2Info;
    }

    public Image getOddEyeUP1Info() {
        return oddEyeUP1Info;
    }

    public Image getOddEyeUP2Info() {
        return oddEyeUP2Info;
    }

    //method to collect and modify coordinate info, similar implementation to 2.5D game
    //call KeyEvent

    /**
     * keyPressed(): listens to key input to see if key is pressed, should trigger a flag (1 or -1 in this case)
     * @param e KeyEvent parameter
     */
    public void keyPressed(KeyEvent e){
        int userKey = e.getKeyCode();

        //ifs to see where coordinates are updated
        //MOVE by 1 (flag) at a time (UP RIGHT POS/ DOWN LEFT NEG)
        if(userKey == KeyEvent.VK_UP){
            y_coordinateUpdater = -1;
        }
        else if(userKey == KeyEvent.VK_DOWN){
            y_coordinateUpdater = 1;
        }
        else if(userKey == KeyEvent.VK_LEFT){
            //System.out.println("GOING LEFT!");
            x_coordinateUpdater = -1;

        }
        else if(userKey == KeyEvent.VK_RIGHT){
            x_coordinateUpdater = 1;
        }
        /*else{
            System.out.println("INVALID INPUT!");
        }*/

        /*if(x_coordinateUpdater < 0 || y_coordinateUpdater < 0){
            System.out.println("OUT OF BOUNDS RETURN TO GAME GRID!!");
        }*/
        //print out coordinates to the console (for program and debugging purposes)
        //System.out.println("Current coordinates: (" +x_coordinate + "," +y_coordinate +")");
    }

    //include method for key released
    //program syntax similar to keyPressed, set values to 0 (essentially a BF)

    /**
     * keyReleased(): should set 0 if any of the keys are let go
     * @param e KeyEvent parameter
     */
    public void keyReleased(KeyEvent e){

        int userKey = e.getKeyCode();

        //ifs to see where coordinates are updated
        if(userKey == KeyEvent.VK_UP){
            y_coordinateUpdater = 0;
        }
        else if(userKey == KeyEvent.VK_DOWN){
            y_coordinateUpdater = 0;
        }
        else if(userKey == KeyEvent.VK_LEFT){
            x_coordinateUpdater = 0;

        }
        else if(userKey == KeyEvent.VK_RIGHT){
            x_coordinateUpdater = 0;
        }
        /*else{
            System.out.println("INVALID INPUT!");
        }*/

        /*if(x_coordinateUpdater < 0 || y_coordinateUpdater < 0){
            System.out.println("OUT OF BOUNDS RETURN TO GAME GRID!!");
        }*/
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