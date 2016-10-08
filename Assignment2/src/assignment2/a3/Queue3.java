/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a3;

import assignment2.a2.*;


/**
 *
 * @author usuario
 */
public class Queue3 {

    int n;
   
    boolean readerturn = false;
    boolean read = false;
    
    synchronized public void read() throws InterruptedException {

        if (!readerturn) {
            this.wait();
        }
        /*Critical Section*/
        
        if(read==false){
            System.out.println("R:"+ Thread.currentThread().getId()+"___>" + n);
            read = true;
            
        }
        
        readerturn = false;
        notifyAll();
        /*Critical Section*/

    }
    

    synchronized public void write(int x) throws InterruptedException {

        if (readerturn) {
            this.wait();
        }
        /*Critical Section*/
        n = x;
        System.out.println("W:" + n);
        
        readerturn = true;
        read = false;
        notifyAll();
        /*Critical Section*/
    }
}
