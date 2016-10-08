package assignment2.a3;

import assignment2.a2.*;
import assignment2.a1.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Writer3 implements Runnable{
    Queue3  q;
    Writer3 (Queue3 q){
        this.q = q;
        new Thread(this, "Writer").start();
    }
    
    @Override
    public void run() {
        
        int i =0;
        for (int j = 0; j < 10; j++) {
                        try{
                try{
                    Thread.sleep((long)(Math.random()*500));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                q.write(i++);
            }catch(InterruptedException ex){
                Logger.getLogger(Writer3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
    
}
