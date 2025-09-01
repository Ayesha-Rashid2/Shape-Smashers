/**
 * Name: Ayesha Rashid
 * Project Name: Shape Smashers

 * 
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;
 import java.util.Random;
 
 public class ShapeSmashers extends JPanel {

    //J Variable, K Variables, and Timers
     private JFrame frame;
     private JLabel instructions;
     private JLabel instructionsp2;
     private JLabel scoreLabel;
     private JLabel usernameLabel;
     private JButton restartButton;
     private KeyTracker kt;
     private Timer gameTimer;
 
     // int and string variables
     private String username;
     private int score = 0;
     private final int gameTime = 10; // seconds
     private int timeLeft;

     // etc variables
     private ArrayList<Circle> circles;
     private Random rand;
 
     public ShapeSmashers() {
        // To Generate new circles across the frame
         rand = new Random();
         circles = new ArrayList<>();
         generateCircles();
 
         //Sets the JFrame 
         frame = new JFrame("Shape Smashers");
         this.setPreferredSize(new Dimension(600, 600));
         this.setBackground(Color.WHITE);
         this.setLayout(null);

         // Sets the Instructions set to appear to frame
         instructions = new JLabel("Click on as many circles as possible in 10 seconds!");
         instructionsp2 = new JLabel("Press 'X' to Exit the Game");
         instructions.setBounds(100,10,400,30);
         instructionsp2.setBounds(150,30,400,30);
         this.add(instructions);
         this.add(instructionsp2);

         // Collects and sets character username to appear to frame
         username = JOptionPane.showInputDialog("Enter your character name:");
         usernameLabel = new JLabel("Character: " + username);
         usernameLabel.setBounds(480, 45, 200, 30);
         this.add(usernameLabel);
 
         // Sets the initial scoreboard which will be updated with scores
         scoreLabel = new JLabel("Score: 0");
         scoreLabel.setBounds(20, 20, 100, 30);
         this.add(scoreLabel);
 
         //Sets the JButton to allow players to restart the program
         restartButton = new JButton("Restart");
         restartButton.setBounds(480, 20, 100, 30);
         restartButton.addActionListener(new RestartListener());
         this.add(restartButton);
         this.addMouseListener(new ShapeClickListener());

         //Sets the exit key to allow players to exit the program
         kt = new KeyTracker();
         this.setFocusable(true);
         this.addKeyListener(kt);
         this.requestFocusInWindow();

         //Updates the JFrame to appear on screen
         frame.add(this);
         frame.pack();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
 
         // Starts the Game Time
         startGameTimer();
     }
 
     // Sets a GameTime Method for updated JPanel
     private void startGameTimer() {
         if (gameTimer != null && gameTimer.isRunning()) { // This ensures that game timer stays consistant, no matter restarts
             gameTimer.stop();  // Built in to stop the game timer
         }
 
         timeLeft = gameTime; // Time left updates as gameTime decreases
         gameTimer = new Timer(1000, new ActionListener() {   // Allows a new timer system to be created 
             public void actionPerformed(ActionEvent e) {
                 if (timeLeft > 0) {
                     timeLeft--; // Game time decreases
                     generateCircles(); //Generates new Circles everytime 
                     frame.repaint();
                 } else {
                     gameTimer.stop();
                     JOptionPane.showMessageDialog(frame, "Time's up! Your Final Score is: " + score);
                 }
             }
         });
         gameTimer.start();
     }

     // Method for Creating new Circles
     private void generateCircles() {
        circles.clear(); // clears existing circles
         int numCircles = rand.nextInt(5) + 10; // Generates between 10 and 15 circles
         for (int i = 0; i < numCircles; i++) {
             int x = rand.nextInt(500);
             int y = rand.nextInt(500) + 50;
             circles.add(new Circle(x, y, 60)); //Appends all circles to an ArrayList
         }
     }
 
     // Paints and updates circles visuals
     public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        for (Circle c : circles) {
              c.draw(g2d);
          }
     }
 
     // Circle class for randomzizing, and updating circles 
     private class Circle {
         private int x, y, size;
         private Color color;
 
         public Circle(int x, int y, int size) {
             this.x = x;
             this.y = y;
             this.size = size;
             this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
         }

         // Getter methods for returns specific traits of the circle
         public int getY() {
            return y;
         }
         public int getX() {
            return x;
         }
         public int getRadius() {
            return 30;
        }
 
         public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.fillOval(x, y, size, size);
         }
     }

     private class ShapeClickListener implements MouseListener {
         public void mouseClicked(MouseEvent e) {
             int x = e.getX();
             int y = e.getY();

             //Determines if mouse clicked is within a circle radius
             for (int i = 0; i < circles.size(); i++) {
                Circle circle = circles.get(i);
                int centerX = circle.getX() + circle.getRadius();
                int centerY = circle.getY() + circle.getRadius();
                
                int dx = x - centerX;
                int dy = y - centerY;
                double distance = Math.sqrt(dx * dx + dy * dy);
            
                //If a mouse clicked is within circle radius ___ will happen
                if (distance <= circle.getRadius()) {
                    circles.remove(i); // Remove circles from screen
                    score++; //Update scoreboard
                    scoreLabel.setText("Score: " + score); //Update Score Screen
                    frame.repaint(); //Repaint the frame
                    break;
                }
            }
         }
         public void mousePressed(MouseEvent e) { }
         public void mouseReleased(MouseEvent e) { }
         public void mouseEntered(MouseEvent e) { }
         public void mouseExited(MouseEvent e) { }
     }
 

     // Class that will handle the restart button
     private class RestartListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             score = 0;
             scoreLabel.setText("Score: 0");
             generateCircles();
             frame.repaint();
             startGameTimer();

             //Request focus so that 'X' key works again once program has restarted 
             ShapeSmashers.this.requestFocusInWindow();
         }
     }


     // Class thaat will handle key tracking, used 'X' to exit the program
     private class KeyTracker implements KeyListener {
        public void keyPressed(KeyEvent m) {
            int code = m.getKeyCode();
            if (code == KeyEvent.VK_X) { // If 'X' is pressed, system will close
                System.exit(0);
            }
            frame.repaint();
        }

        public void keyReleased(KeyEvent arg0) { }
        public void keyTyped(KeyEvent e) { }
     }

 }