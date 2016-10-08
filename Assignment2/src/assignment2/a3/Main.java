/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a3;

import assignment2.a2.*;
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
        Queue3 queue3;
        queue3 = new Queue3();
        new Reader3(queue3);
        new Reader4(queue3);
        new Writer3(queue3);
        
        
    }
    
}
