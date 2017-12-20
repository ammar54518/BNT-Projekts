/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ammar
 */
public class Frame extends JFrame{

    
    
    final Player player;
    final Background bg; // background gb was initialized
    
    
   
    private BufferStrategy strat; // BufferStrategy Strat was set as an attribute
    
    public Frame(Player player, Background bg){ // value of background was used
        super("MoveTest");
        addKeyListener(new Keyboard());
        this.player = player;
        this.bg = bg; // bg was initialized
    }
    
    public void makeStrat(){ // sets makeStrar as a method whiich does everthing bellow
        createBufferStrategy(2); // creates 2 createBufferStrategys
        strat = getBufferStrategy(); // the variable strat was initialized as getBufferStrategy()
    }
    
   
    
    
    public void repaintScreen(){
        Graphics g = strat.getDrawGraphics(); // get strat and draw it 
        draw(g); // zeichne g
        g.dispose(); // deletes graphics objekts
        strat.show(); // checks if everything is working
    }
    
    private void draw(Graphics g) {
         g.setColor(Color.GREEN);
            
         g.drawImage(bg.getLook() , bg.getX() , 0, null); // gives the programm the picture and size of the picture to draw it
         g.drawImage(bg.getLook(), bg.getX()+bg.getLook().getWidth(), 0, null);
         g.drawImage(player.getLook(), player.getBounding().x, player.getBounding().y, null); // sets the boundaries of the player in scale of the picture
    }
    

}

  