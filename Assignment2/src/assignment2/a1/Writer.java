/*
 * To change this license header, choose License Headers in Project Properties.
 * To change thad(this, "Writer").start();
    }is template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a1;

/**
 *
 * @author usuario
 */
public class Writer implements Runnable{
    Queue  q;
    Writer (Queue q){
        this.q = q;
        new Thread(this, "Writer").start();
    }
    
    @Override
    public void run() {
    
        int i = 0;
        for (int j = 0; j < 10; j++) {
            try{
                Thread.sleep((long)(Math.random()*500));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            q.write(i++);
        }
        
    
    }
    
}
