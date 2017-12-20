/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ammar
 */
public class Background {
    private float f_posx; // f_posx was set as an attribute
    private float f_speed;// f_speed was set as an attribute
    private BufferedImage look; // BufferedImage was set as an attribute
    
    public Background (float f_speed) { // The backround shud move in f_speed
        this. f_speed = f_speed; // f_speed is the same value as the variable f_speed
        
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/weltraum.png")); // imports and loads a picture
        } catch (IOException e) {e.printStackTrace();}
        
    }
    
    public void update (float timeSinceLastFrame){
        f_posx-=f_speed*timeSinceLastFrame; // the picture shud go in the negtiv x diretion
        if(f_posx<-look.getWidth())f_posx+=look.getWidth(); // if posx is less the look width then repaint to posx + width look
    }
   
    public int getX(){ // get the x position for for returning it
        return (int)f_posx; // return the x position for use
    }
    public BufferedImage getLook(){ //get look for for returning it
        return look; // return look for use
    }
}
