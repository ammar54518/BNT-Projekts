/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;


import java.awt.DisplayMode; // DisplayMode was set as an attribute 
import java.awt.GraphicsDevice; // GraphicsDevice was set as an attribute 
import java.awt.GraphicsEnvironment; // GraphicsEnvironment was set as an attribute 
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class MoveTest {
    public static void main(String[] args) {
        Player player = new Player(300, 300, 1680, 1050); // sets  the boundaries of the player
        Background bg = new Background(100); // bg was set the speed of the background moving to 500 pixel
        
        
        
        Frame f = new Frame(player, bg); // gets the value of the background speed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setUndecorated(true); // turns of things like the titel 
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null); // opens the window in the middle of the screen
        DisplayMode displayMode = new DisplayMode(1680, 1050, 32, 60); // variable displayMode was initialized to Displaymode which declares the fullscreen size ,bitdepth and refreshrate
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment(); // variable enviroment was initalized to GraphicsEnvironment.getLocalGraphicsEnvironment() which checks how many screens are pluged in 
        GraphicsDevice device = environment.getDefaultScreenDevice(); // variable device was initalized to environment.getDefaultScreenDevice to get the default screen of the pc
        
        device.setFullScreenWindow(f); // this is a method makes the game in frame fullscreen
        device.setDisplayMode(displayMode); // this is a method that enables the variable displayMode
        
        f.makeStrat(); //uses the mehtod makeStrat()
        
        
        
       
        
        long lastFrame = System.currentTimeMillis(); // lastFrame was declared to the system time of the current frame in milliseconds
        while(true){
            if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0); // if you press escape the game will close
            
            
            long thisFrame = System.currentTimeMillis(); // thisFrame was declared to the system time of the current frame in milliseconds
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f; // timeSinceLastFrame was declared to thisFrame minus lastFrame devided by 1000 to get the result in seconds
            lastFrame=thisFrame; // lastFrame is declared to thisFrame to save the time of the last frame so it can be used in the next run through
            
           
            
            player.update(timeSinceLastFrame); // timeSinceLastFrame was initialized to be used in player.update
            bg.update(timeSinceLastFrame); 
            f.repaintScreen();
            
            
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}