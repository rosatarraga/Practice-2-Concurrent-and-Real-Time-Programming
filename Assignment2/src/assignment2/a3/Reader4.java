/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a3;

import assignment2.a2.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author usuario
 */
public class Reader4 implements Runnable{
    Queue3 q;
    Reader4 (Queue3 q){
        this.q = q;
        new Thread(this,"Reader Two").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                try{
                    
                    Thread.sleep((long) (Math.random()*500));
                    
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                q.read();
                
            }catch(InterruptedException ex){
                Logger.getLogger(Reader3.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
            
}
