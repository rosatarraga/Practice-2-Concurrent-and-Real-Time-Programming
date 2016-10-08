/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a1;

/**
 *
 * @author usuario
 */
public class Queue {
    
    int n;
    volatile boolean readerturn = false;
    volatile boolean readerturn2 = false;
    
    
    
    
    public void read(){
        
        
        /*Critical Section*/
        while(!readerturn);
        System.out.print("R1:");
        System.out.println(n);
        readerturn = false;
        /*Critical Section*/
    }
    /*
    public void read2(){
        while(!readerturn2 && readerturn);
        System.out.print("R2:");
        System.out.println(n);
        readerturn2 = false;
        
        */
    
        
    public void write(int x){
     
        /*Critical Section*/
        while(readerturn);
        n = x; 
        System.out.println("W:"+n);
        readerturn = true;
        /*Critical Section*/
    }
}
