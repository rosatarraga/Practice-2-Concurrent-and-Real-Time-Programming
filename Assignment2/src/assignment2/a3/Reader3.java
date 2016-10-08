package assignment2.a3;

import assignment2.a2.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author usuario
 */
public class Reader3 implements Runnable{
    Queue3 q;
    Reader3 (Queue3 q){
        this.q = q;
        new Thread(this,"Reader One").start();
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
