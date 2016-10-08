/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.a1;

import assignment2.a1.Reader;
import assignment2.a1.Queue;
import assignment2.a1.Writer;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue queue;
        queue = new Queue();
        
        new Writer(queue);
        new Reader(queue);
        
    }
    
}
