/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ammar
 */
public class Keyboard implements KeyListener{ // method to know wich button was pressed
    private static boolean[] keys = new boolean[1024]; // created a array with a boolean value of 1024
   
    public static boolean isKeyDown(int keyCode){ 
        if(keyCode>=0&&keyCode<keys.length) return keys[keyCode];//if key code is smaller then 0 set the keys at position keyCode to true else return false
        else return false;
    }
        

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // the keyCode equalts e.getKeyCode
        if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=true; ; // if key code is smaller then 0 set the keys at position keyCode to true 
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode(); // the keyCode equalts e.getKeyCode
        if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=false;  // if key code is smaller then 0 set the keys at position keyCode to true 
    }
    
     // useless
    @Override
    public void keyTyped(KeyEvent e) {}
       
    
}
