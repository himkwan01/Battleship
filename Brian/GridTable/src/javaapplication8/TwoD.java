/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * line 33,41 useless need to fix
 */
package javaapplication8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TwoD extends JFrame{
private static final int a = 5;
private static JFrame frame = new JFrame("MyTttFoo");
private JButton[][] button;
private Dimension bDim = new Dimension(20,20);
private Dimension pDim = new Dimension(100, 100);

  public TwoD() {
    ActionListener clk = new ButtonListener();
    JPanel jp = new JPanel();
    jp.setPreferredSize(pDim); //useless
    jp.setLayout(new GridLayout(a,a));
    //declare size of button array
    button = new JButton[a][a];
    for(int i=0;i<a;i++){
      for(int j=0;j<a;j++){
        //create new object
        button[i][j] = new JButton(Integer.toString(i)+" "+Integer.toString(j));
        button[i][j].setPreferredSize(bDim);  //useless
        button[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button[i][j].addActionListener(clk);
        jp.add(button[i][j]);
      }
    }
    
    //define jframe and add objects
    frame.setSize(new Dimension(500,500));
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(jp);
    frame.setResizable(false);
  }
  
  //make a own ActionListener class
  //need to be change to left click only
  //and disable that button
  private class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      for (int i = 0; i < a; i++){
        for (int j = 0; j < a; j++){
          if(e.getSource()==button[i][j]){ //gameButtons[i][j] was clicked
           //Your code here
            System.out.println(i+" "+j);
          }
        }
      }
    }
  }
   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        public void run() {
          new TwoD(); //create a TwoD object
          frame.setVisible(true);
        }
      });
   }
}