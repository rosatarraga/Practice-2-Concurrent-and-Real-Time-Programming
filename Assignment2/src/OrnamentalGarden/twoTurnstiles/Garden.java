/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrnamentalGarden.twoTurnstiles;


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.*;


public class Garden extends Applet {

    Button goButton;
    Turnstile turnstile1;
    Turnstile turnstile2;
    Counter counter;
    NumberCanvas counterD;
    NumberCanvas turn1D;
    NumberCanvas turn2D;
    int id1=0;
    int id2=1;
//    Checkbox fixit;
    public final static int MAX = 20;


    public void init() {
        super.init();
	setBackground(Color.lightGray);
        // Set up Button 
        Panel p0= new Panel();
        p0.add(goButton = new Button(" Simulate "));
        goButton.setFont(new Font("Helvetica",Font.BOLD,24));
		
        goButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
           if (turnstile1==null && turnstile2==null)
              go();
          else if (!turnstile1.isAlive() && !turnstile2.isAlive())
              go();         
          }
        });
	Panel p=new Panel();
        Label lb=new Label("Ornamental Garden");
        lb.setFont(new Font("Arial",Font.BOLD,24));
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        p.add("South",lb);

        Panel p1= new Panel();
        p1.setLayout(new BorderLayout());
        
        p1.add("Center",p0);

        // Set up Display
        Panel p2 = new Panel();
        counterD = new NumberCanvas("Counter");
        turn1D   = new NumberCanvas("Turnstile 1",Color.ORANGE);
        turn2D   = new NumberCanvas("Turnstile 2",Color.ORANGE);
        counterD.setSize(150,100);
        turn1D.setSize(100,100);
        turn2D.setSize(100,100);
        p2.add(turn1D);
        p2.add(counterD);
        p2.add(turn2D);
        // Arrange Applet display
        setLayout(new BorderLayout());
        add("North",p);
        add("Center",p2);
        add("South",p1);
        
    }

    private void go() {
        
        counter = new Counter(counterD);
       
        turnstile1= new Turnstile(turn1D,counter,id1);
        turnstile2= new Turnstile(turn2D,counter,id2);
        turnstile1.start();
        turnstile2.start();
    }

}

class Counter {

    int value=0;
    NumberCanvas display;
    boolean [] wantsCS = {false, false};
    volatile int turn = 0;
        
    Counter(NumberCanvas n) {
        display=n;
        display.setvalue(value);
    }

    void increment(int ID) {
        
        //pre-protocol
        wantsCS[ID] = true;
        while(wantsCS[1-ID]){
            if (turn == 1-ID){
                wantsCS[ID] = false;
                while(turn == 1-ID);
                wantsCS[ID] = true;
            }
        }
        /*CS*/
        int temp = value;   //read[v]
        CC.ForceCC();
        value=temp+1;       //write[v+1]
        display.setvalue(value);
        /*CS*/
        
        
        //post-protocol
        turn=1-ID;
        wantsCS[ID] = false;
        
        
        
    }
}




class Turnstile extends Thread {
  NumberCanvas display;
  Counter people;
  int ID;
  Turnstile(NumberCanvas n,Counter c, int id)
    { display = n; people = c; ID = id;}

  public void run() {
    try{
      display.setvalue(0);
      for (int i=1;i<=Garden.MAX;i++){
        Thread.sleep(500); //0.5 second
        display.setvalue(i);
        people.increment(ID);
      }
    } catch (InterruptedException e) {}
  }
}

class CC {
    public static void ForceCC() {
        if (Math.random()<0.5)
           try{Thread.sleep(200);} catch(InterruptedException e){};
            
    }
}
