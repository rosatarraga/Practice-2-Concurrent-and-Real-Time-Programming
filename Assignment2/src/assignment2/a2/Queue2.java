/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a2;


/**
 *
 * @author usuario
 */
public class Queue2 {
    
    int n;
    boolean readerturn = false;
  
    
    
    
    
    synchronized public void read() throws InterruptedException{
        
        
      
        if(!readerturn){
            this.wait();
        }  
        /*Critical Section*/
        System.out.print("R1:");
        System.out.println(n);
        this.notify();
        readerturn = false;
        /*Critical Section*/
    }

        
    synchronized public void write(int x) throws InterruptedException{
     
        
        if(readerturn){
            this.wait();
        }
        /*Critical Section*/
        n = x; 
        System.out.println("W:"+n);
        this.notify();
        readerturn = true;
        /*Critical Section*/
    }
}
