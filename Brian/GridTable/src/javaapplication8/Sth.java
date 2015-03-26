/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sth extends JFrame{
private static final int a = 3;
private static JFrame frame = new JFrame("MyTttFoo");
private JButton[] button;


  public Sth() {
    ActionListener clk = new ButtonListener();
    JPanel jp = new JPanel();
    jp.setSize(100, 100);
    jp.setLayout(new GridLayout(a,a));
     button = new JButton[a];
    for(int i=0;i<a;i++){
        button[i] = new JButton(Integer.toString(i));
        button[i].setSize(20, 20);
        button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button[i].addActionListener(clk);
        jp.add(button[i]);
    }
    //jp.setVisible(true);
    //define jframe and add objects
    frame.setSize(110, 110);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(jp);
    frame.setResizable(false);
  }
  
  //make a own action listener class
  private class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      for (int i = 0; i < a; i++){
  //      for (int j = 0; j < ROWS; j++){
          if(e.getSource()==button[i]){ //gameButtons[i][j] was clicked
           //Your code here
            System.out.println(i);
          }

      }
    }
  }
   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        public void run() {
          new Sth();
          frame.setVisible(true);
        }
      });
   }
}