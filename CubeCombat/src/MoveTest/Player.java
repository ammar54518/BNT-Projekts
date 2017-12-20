/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



/**
 *
 * @author Schueler
 */
public class Player {
    private Rectangle bounding;
    private float f_posx;
    private float f_posy;
    private int worldsize_x; //worldsize_x was set as an attribute
    private int worldsize_y; //worldsize_y was set as an attribute
    private BufferedImage look; // BufferedImage was set as an attribute
    
    public Player (int x, int y, int worldsize_x, int worldsize_y ){ try {
        //Variable worldsize_x and wokrldsize_y was initialzed
        look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/raumschiffchen.png")); // imports and loads a picture
        bounding = new Rectangle(x, y, look.getWidth(), look.getHeight()); // look.getWidth gets the width of the picture look.getHeight  gets the height of the picture
        f_posx = x;
        f_posy = y;
        this.worldsize_x = worldsize_x; //The Variable worldsize_x was declared to the size of the x coordinates  
        this.worldsize_y = worldsize_y; //The Variable worldsize_y was declared to the size of the y coordinates
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex); // 
        }
        
        

    }

    
    
    public void update (float timeSinceLastFrame){ // timeSinceLastFrame was initialized so that it will be required in player.update
         if(Keyboard.isKeyDown(KeyEvent.VK_W))f_posy-=300*timeSinceLastFrame; // the speed of the player was defined to moving 300 pixel times the time since the lastframe when going up
         if(Keyboard.isKeyDown(KeyEvent.VK_S))f_posy+=300*timeSinceLastFrame; // the speed of the player was defined to moving 300 pixel times the time since the lastframe when going down
         if(Keyboard.isKeyDown(KeyEvent.VK_D))f_posx+=300*timeSinceLastFrame; // the speed of the player was defined to moving 300 pixel times the time since the lastframe when going right
         if(Keyboard.isKeyDown(KeyEvent.VK_A))f_posx-=300*timeSinceLastFrame; // the speed of the player was defined to moving 300 pixel times the time since the lastframe when going left
         
         if(f_posx<0)f_posx=0; //if the player wants to go past posx 0>x then redraw the player back at posx 0
         if(f_posy<0)f_posy=0; //if the player wants to go past posy 0>x then redraw the player back at posy 0
         if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;// if the player posx is bigger then the worldsize_x minus the players width then redraw the position of the player on the position worldsize_x minus the players width
          if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height; // if the player posy is bigger then the worldsize_y minus the players hight then redraw the position of the player on the position worldsize_y minus the players hight 
    
         
         bounding.x=(int)f_posx;
         bounding.y=(int)f_posy;
         
         
        
    }
    public Rectangle getBounding(){
        return bounding;
    }
    
    public BufferedImage getLook(){
        return look;
    }
}

