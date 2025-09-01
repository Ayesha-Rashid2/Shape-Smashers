import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Project2Runner {
    
    /*
     * Name: Ayesha Rashid
     * Student ID: a28rashi
     * 
     ******** Project Description ********
     * Description: A clicker game where players click on randomly generated shapes within a time limit to earn points.
     * Players can click a circle in a frame and then those circles are removed from the screen.
     * However, the catch is that every second, the circles are randomly generated in new places, so that the player has to click really fast to keep scoring.
     * The total game time is 10 seconds, and my personal highest score was 15. 
     * This program features a ton of features such as a restart button, a scoreboard, and a exit key for the user to press to exit the game.
     * Some Event Listeners were MouseListener for shape clicking, ActionListener for timer & ActionListener for Restart
     * Additionally Keylisteners for detecting the 'X' Key 
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     *
     * 
     ******** Swing Requirement ********
     * 
     *  This game has three Swing components: JButton (Restart), JOptionFrame, JLabel (Character Name, Score & Instructionss)
     * JButton for restart is initialzed on line 67-72 and programmed to restart the program in its seperate class starting 195
     * JLabels are initialzed and used to display text for scoreboard, and another 3 for displaying important detailing surrounding instructions and asking the user to input a username
     * JOptionFrame was featured so that players could input a character username, to make their experience more unique, and it was displayed on screen.
     * 
     ******** 2D Graphics Requirement ********
     *
     * The program satisfies the requirement of using at least one JPanel for drawing by defining a custom class that extends JPanel
     * JPanel is extended on Shapesmashers, the class itself which is responsible for updating the graphics and imaging of the program.
     * The paincomponent for example, called on line 124 to draw each circles and update them accordingly 
     * These circles are drawn through draw which also calls Graphics, and updates them to be 2D 
   
     * 
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * The program also fifils this requirement as there is a restartListener which attaches the restart button to rerun the program, when the button is pressed. 
     * Moreover, there is also another Actionlistener which is implemented in Mouselistener, allowing the 'X' key to be used as an exit button for users. 
     * The Gametimer also calls a new ActionListener allowing there to be a gameTime that is contiously being updated as the program is ran. 
     */

    public static void main(String[] args) {
        ShapeSmashers s = new ShapeSmashers();      



    }
}
