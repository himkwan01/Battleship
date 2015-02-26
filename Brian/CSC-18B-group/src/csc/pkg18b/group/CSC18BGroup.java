/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg18b.group;

import GamePackage.Game;
import java.util.Scanner;

/**
 *
 * @author Himkw_000
 */
public class CSC18BGroup {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    intro();
    Scanner cin = new Scanner(System.in);
    int num;
    boolean invalid=false;
//    do{
      num=0;
      invalid=false;
      //input size
      System.out.print("Please enter the size of the table (8-10):");
      num=cin.nextInt();
      //validation not done
//      try{
//        numTest(num);
//  //      System.out.print("test\n");
//      }
//      catch(string numException){
//        invalid=true;
//        System.out.print(numException;
//
//      }
      Game player = new Game(num);
      Game ai = new Game(num, 'c');
      player.print(ai);
//    }while(invalid==true);
    
//    why<test> a(num);

    }
  public static void intro(){
    System.out.print("Battleship!\n");
    System.out.print("You have 5 ship to place\n");
    System.out.print("5 units ship*1 55555, 4 units ship*1 4444\n");
    System.out.print("3 units ship*1 333, 2 units ships*2 22, 22\n");
  }

}
