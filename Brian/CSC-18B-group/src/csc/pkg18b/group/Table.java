/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg18b.group;

/**
 *
 * @author Himkw_000
 */
public class Table {
  //fake table display to the player
  //real for record
  protected char[][] fake;
  protected char[][] real;
  protected int num; //size of the table num * num
  
  public Table(int num){
    System.out.println("Table Constructor");
    this.num=num;
    //set the size of the table
    fake = new char[num][num];
    real = new char[num][num];
    //initialize the tables
    for(int i=0;i<num;i++){
      for(int j=0;j<num;j++){
        fake[i][j]=' ';
        real[i][j]=' ';
      }
    }
  } //Table constructor ends
  //get the size of the array row==col its a square
  public final int getNum(){
    return num;
  }
  //get individual box value
  public char getTable(int x, int y){
    return real[x][y];
  }
  //x, y coordinates, i is value
  public void setTable(int x, int y, char i){
    fake[x][y]=i;
    real[x][y]=i;
  }
  
}
