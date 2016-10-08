/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a1;

import assignment2.a1.Queue;

/**
 *
 * @author usuario
 */
public class Reader implements Runnable{
    Queue q;
    Reader (Queue q){
        this.q = q;
        new Thread(this,"Reader").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                
                Thread.sleep((long) (Math.random()*500));
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            q.read();
        }
    }
            
}
