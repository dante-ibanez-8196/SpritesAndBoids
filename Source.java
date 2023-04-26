/**
 * @author Dante Ibanez
 * @version 0.01
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Source extends JFrame{
    //declare new OddEye player
    OddEye player = new OddEye();
    //main (set a constructor and method to load map through included methods
    public Source(){
        beginLoading();
    }

    /**
     * beginLoading() loads WorldMap content with included classes
     */
    public void beginLoading(){
        //call swing included classes to set up the game environment
        add(new WorldMap());
        setTitle("OddEye The Greater Devil Adventurer"); //game title!!
        //set the size to the input map height and width
        setSize(player.getMapHeight(), player.getMapHeight());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allow user to close game through the window option
    }

    /**
     * Main method: Drivers to the program, allows user to quit manually
     * @param args standard args
     */
    public static void main (String [] args){
        //call invokeLater from EventQueue to actually display the game
        //declare Source obj and set it to a true visible
        EventQueue.invokeLater(() -> {Source sourceObj = new Source(); sourceObj.setVisible(true);});
        //print out to terminal for debugging/confirmation to the user, manual quits
        System.out.println("Welcome to the game. These system outs are for debugging/confirmation of the game running.");
        System.out.println("If you wish to kill this program, type QUIT to QUIT program.");
        Scanner userInput = new Scanner(System.in);
        String quitCommand = userInput.nextLine();
        String quitGame = "QUIT";
        System.out.println("Input: " +quitGame); //debugging remove later
        //quit via user command
        if(quitCommand.equals(quitGame)){
            System.exit(0);
        }
    }
}