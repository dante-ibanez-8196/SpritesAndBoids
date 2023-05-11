import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * WorldMap: a new class designed to display the world map and use the OddEye player
 * Includes method calls within the awt and swing packages and associated libraries
 * 
 * THIS UDPATED CLASS CONTAINS CALLS FROM THE OTHER PLAYER
 */
public class WorldMap extends JPanel implements ActionListener {
    //declare the player obj and the timer (set the delay param time to 20 below)
    public OddEye oddEyePlayer;
    public RedBaron redBaronPlayer; //other player
    public Explosion explosion; //explosion when players hit
    public Timer gameTimer;

    public Graphics explosionGraphics;
    public Graphics2D graphics2D;

    Image gameImage;
    //constructor
    //simply load world map
    public WorldMap() {
        loadTheWorldMap();
    }

    //load the world map (use swing classes)

    /**
     *loadTheWorldMap(): loads the necessary attributes and methods
     */
    public void loadTheWorldMap() {
        //load the gif from the player class
        //oddEyePlayer.loadBackgroundImage();
        //gameTimer.start();

        addKeyListener(new HandleKeyInputs()); //add HandleKeyInputs class to KeyListener
        //setBackground(Color.green); //set background as a green default, load world map later if possible

        setFocusable(true);

        //declare player and timer
        oddEyePlayer = new OddEye();
        redBaronPlayer = new RedBaron();
        explosion = new Explosion();

        gameTimer = new Timer(20, this);
        gameTimer.start();

    }

    //load graphics + swing classes

    /**
     * paintComponent(): takes in Graphics and calls included methods
     * @param graphics the <code>Graphics</code> object to protect
     */
    public void paintComponent (Graphics graphics){
        //look up graphics associated classes
        super.paintComponent(graphics);
        loadTheContent(graphics); //load content via drawImage() below
        displayTheExplosion(graphics);
    }

    /**
     * loadContent(): load content for the World Map, use graphics2d tp draw images from player
     * @param graphics
     */
    public void loadTheContent(Graphics graphics){
        graphics2D = (Graphics2D) graphics;
        //draw the background
        //declare each sprite
        //load the world map gif
        graphics2D.drawImage(oddEyePlayer.returnBackgroundImage(), 0, 0, this);
        //load the player and the components himself!! (drawImage(img, x, y, observer to null)
        graphics2D.drawImage(oddEyePlayer.getOddEyeDOWN1Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeDOWN2Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeLEFT1Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeLEFT2Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeRIGHT1Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeRIGHT2Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeDOWN1Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);
        graphics2D.drawImage(oddEyePlayer.getOddEyeDOWN2Info(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), this);

        //red baron
        //graphics2D.drawImage(redBaronPlayer.getRed, null, ALLBITS, ABORT);
        graphics2D.drawImage(redBaronPlayer.getRedBaronDOWN1Info(), redBaronPlayer.getX_coordinate(), redBaronPlayer.getY_coordinate(), this);

        //graphics2D.drawImage(explosion.explosionInfo(), explosion.getX_coordinate(), explosion.getY_coordinate(), null);
    }
    //call to move player

    /**
     * Simply call moveOddEye() method below
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        moveOddEye();
        moveRedBaron();
        playersCollide();
    }

    /**
     * moveOddEye: call included move method form player and repaint
     */

    //TEMP MAKE THESE RETURN A VALUE
    public void moveOddEye(){
        //call move and repaint
        oddEyePlayer.movePlayer();

        repaint(oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), oddEyePlayer.getMapWidth(), oddEyePlayer.getMapHeight());
        System.out.println("Coordinates ODDEYE : (" +oddEyePlayer.getX_coordinate() + "," +oddEyePlayer.getY_coordinate() +")");

    }

    //new redbaron move class
    public void moveRedBaron(){
        //call move and repaint (call oddeye for map info as it's saved there)
        redBaronPlayer.movePlayer();

        repaint(redBaronPlayer.getX_coordinate(), redBaronPlayer.getY_coordinate(), oddEyePlayer.getMapWidth(), oddEyePlayer.getMapHeight());
        System.out.println("Coordinates REDBARON : (" +redBaronPlayer.getX_coordinate() + "," +redBaronPlayer.getY_coordinate() +")");

    }

    //new class to determine if both sprites collide
    public void playersCollide(){
        //if statement to check if coordinates for both players are equal (touching each other), then display they touched
        if((redBaronPlayer.getX_coordinate() == oddEyePlayer.getX_coordinate()) && (redBaronPlayer.getY_coordinate() == oddEyePlayer.getY_coordinate())){
            //println debugging
            System.out.println("PLAYERS HAS TOUCHED EACH OTHER!!");
            //call to place explosion
            displayTheExplosion(explosionGraphics);
        }
    }

    public void displayTheExplosion(Graphics graphics){
        //if statement to check if coordinates for both players are equal (touching each other), then display they touched
        if((redBaronPlayer.getX_coordinate() == oddEyePlayer.getX_coordinate()) && (redBaronPlayer.getY_coordinate() == oddEyePlayer.getY_coordinate())){
            //println debugging
            System.out.println("PLAYERS HAS TOUCHED EACH OTHER!!");
            //call to place explosion
            graphics2D.drawImage(explosion.explosionInfo(), oddEyePlayer.getX_coordinate(), oddEyePlayer.getY_coordinate(), null);
        }
    }

    //declare a new class to handle keyboard inputs (call from oddeye)
    //trigger if key has been pressed or released

    /**
     * HandleKeyInputs: small class necessary to move and stop the player if a key has been pressed
     */
    public class HandleKeyInputs extends KeyAdapter {
        /**
         * KeyPressed
         * @param e the event to be processed
         */
        public void keyPressed(KeyEvent e){

            oddEyePlayer.keyPressed(e);
            redBaronPlayer.keyPressed(e);
        }

        /**
         * KeyReleased
         * @param e the event to be processed
         */
        public void keyReleased(KeyEvent e){
            oddEyePlayer.keyReleased(e);
            redBaronPlayer.keyReleased(e);
        }
    }
}