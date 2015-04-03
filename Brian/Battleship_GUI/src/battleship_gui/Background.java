/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship_gui;

import java.util.Random;

/**
 *
 * @author Himkw_000
 */
public class Background {
  int num=10;
  int x1, x2, y1, y2;
  char[][] ai = new char[10][10];
  int[] unit = {5, 4, 3, 3, 2};
  char[][] real = new char[num][num];
  char[][] fake = new char[num][num];
  char[][] player = new char [num][num];
  public Background(){
    for(int i=0;i<num;i++){
      for(int j=0;j<num;j++){
        player[i][j]=' ';
      }
    }
  }
  boolean valid;
  public boolean place(String place, int count){
    valid=true;
    y1=(int)place.charAt(0)-65;
    x1=(int)place.charAt(1)-48;
    y2=(int)place.charAt(2)-65;
    x2=(int)place.charAt(3)-48;
    System.out.println(y1+" "+x1+" "+y2+" "+x2);
    valid=PlaceCheck(count);
    return valid;
  }
  private boolean PlaceCheck(int q){
    int max,min;
    int count=0;
    if(y1==y2){
      System.out.println("same y");
      if(Math.abs(x1-x2)!=unit[q]-1){
        valid=true;
        System.out.println("unit-false");
        return false;
      }
      else{
        if(x1>x2){
          System.out.println("x1>x2");
          max=x1;
          min=x2;
        }
        else{
          System.out.println("x2>x1");
          max=x2;
          min=x1;
        }
        System.out.println("max="+max);
        System.out.println("min="+min);
        System.out.println("p"+y1);
        for(int k=min;k<=max;k++){
          if(player[y1][k]==' '){
            count++;
          }
        }
        System.out.println("count="+count);
        if(count!=unit[q]){
          valid=false;
          System.out.println("overlap-false");
          return false;
        }
        if(valid){
          System.out.println("valid=true");
          for(int k=min;k<=max;k++){
            player[y1][k]=(char)(unit[q]+48);
          }
          return valid;
        }
      }
    }
    if(x1==x2){   //y is same
      if(Math.abs(y1-y2)!=unit[q]-1){ //check unit
        valid=false;
        return valid;
      }
      else{   //valid
        if(y1>y2){
          max=y1;
          min=y2;
        }
        else{
          max=y2;
          min=y1;
        }
        //debug
        System.out.println("max="+max);
        System.out.println("min="+min);
        System.out.println("p"+x1);
        //debug
        for(int k=min;k<=max;k++){
          if(player[k][x1]==' '){
            count++;
            System.out.println("Count="+count);
          }
        }
        if(count!=unit[q]){
          valid=false;
          return false;
        }
        if(valid==true){
          for(int k=min;k<=max;k++){
            player[k][x1]=(char)(unit[q]+48);
          }
          return true;
        }
      }
    }
    if(x1!=x2 && y1!=y2){
      System.out.println("ERROR: not horizontal or vertical");
      return false;
    }
    else return false;
  }
  public void ai(){
    System.out.println("AIprepare running");
    Random rand = new Random();
    for(int i=0;i<num;i++){
      for(int j=0;j<num;j++){
        real[i][j]=' ';
      }
    }
    int count, pos;
  //    boolean valid;
      for(int q=0;q<5;q++){
      do{
        valid=true;
        count=0;
        //random coordinates
        y1=rand.nextInt(10-unit[q]);     //won't over size
        x1=rand.nextInt(10-unit[q]);
        pos=rand.nextInt(2); //random place horizontal or vertical
        if(pos==0){                 //0 horizontal
          for(int k=y1;k<y1+unit[q];k++){
              if(real[k][x1]==' '){
                  count++;
              }
          }
          if(count!=unit[q]){
              valid=false;
          }
          if(valid==true){
              for(int k=y1;k<y1+unit[q];k++){
                  real[k][x1]=(char)(unit[q]+48);
              }
          }
        }
        else{                      //1 vertical
          for(int k=x1;k<x1+unit[q];k++){
              if(real[y1][k]==' '){
                  count++;
              }
          }
          if(count!=unit[q]){
              valid=false;
          }
          if(valid==true){
              for(int k=x1;k<x1+unit[q];k++){
                  real[y1][k]=(char)(unit[q]+48);
              }
          }
        }
      }while(valid==false);
    }
    System.out.println("AI prepared");
  }
  public boolean pFireCheck(String fire){
    valid=true; //reset
    //char input to int index
    y1=(int)fire.charAt(0)-65;
    x1=(int)fire.charAt(1)-48;
    //overlap
    if(real[y1][x1]=='O' || real[y1][x1]=='X'){
      valid=false;
      System.out.println("overlap-false");
    }
    //hit
    else if(real[y1][x1]>='2' && real[y1][x1]<='5'){
      System.out.println("hit, valid");
      real[y1][x1]='X';
    }
    //miss
    else{
      System.out.println("miss, valid");
      real[y1][x1]='O';
    }
    return valid;
  }
}
