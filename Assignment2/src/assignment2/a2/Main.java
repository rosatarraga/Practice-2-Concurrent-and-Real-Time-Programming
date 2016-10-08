/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a2;

import assignment2.a1.*;


/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue2 queue2;
        queue2 = new Queue2();
        
        new Writer2(queue2);
        new Reader2(queue2);
        
    }
    
}
