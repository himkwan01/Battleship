package GamePackage;

import csc.pkg18b.group.Table;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  02/26/15
 *  all variable are default coz i use a function to run the game
 *  Problems: exception
 */
//  !!!!default access modifier only same package
public class Game extends Table{
  //Declare variables
  Scanner cin = new Scanner(System.in);
  Random rand = new Random();
  //start and end coordinates for placing the ship
  int x1, x2, y1, y2;
  /*unit of the ship 5, 4, 3, 3, 2
    aircraft carrier=5, battleship=4
    Submarine =3, Destroyer =3, patrol boat=2
  */
  int[] unit = {5, 4, 3, 3, 2};
  boolean over; //game over boolean
  boolean valid;
  float hit, miss; //accuracy percentage
  boolean win;
  String place; //easy to check the validation format A1A5
  
  //Game Constructor
  public Game(int num){ //for player
    super(num);
    //inititalize
    hit=0;
    miss=0;
    win=false;
  }
  public Game(int num, char c){ //for ai
    super(num);
    int count, pos;
//    boolean valid;
    for(int q=0;q<5;q++){
    do{
      valid=true;
      count=0;
      //random coordinates
      y1=rand.nextInt(num-unit[q]);     //won't over size
      x1=rand.nextInt(num-unit[q]);
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
  hit=0;
  miss=0;
  }
  
  //Print Table function para AI Table object
  public void print(Table o){
    System.out.println("Print Function");
    System.out.println(num);
    System.out.print("   PLAYER 1");
    for(int i=0;i<(num*4+4);i++){
      System.out.print(" ");
    }
    System.out.print("A.I.\n");
    for(int i=0;i<num;i++){
        System.out.printf("%4d",i);
    }
    System.out.print("       ");
    for(int i=0;i<num;i++){
        System.out.printf("%4d", i);
    }
    System.out.println();
    //third line
    System.out.print("  ");
    for(int i=0;i<num;i++){
        System.out.print("____");
    }
    System.out.print("      ");
    for(int i=0;i<num;i++){
        System.out.print("____");
    }
    System.out.println();
    //forth to num line
    for(int i=0;i<num;i++){
        char row=(char)(i+65);
        System.out.print(row+"| ");
        for(int j=0;j<num;j++){
          //player table
            System.out.print(real[i][j]);
            System.out.print(" "+"| ");
        }
        System.out.print("   "+row+"| ");
        
        for(int k=0;k<num;k++){
          //ai table
            System.out.print(o.getTable(i, k));
            System.out.print(" "+"| ");
        }
        System.out.println();
        System.out.print("  ");
        for(int l=0;l<num;l++){
           System.out.print("----");
        }
        System.out.print("      ");
        for(int m=0;m<num;m++){
           System.out.print("----");
        }
        System.out.println();
    }
  }//print function ends
  
  //Player place ship function
  public void Place(Game o){
    print(o);
//    for(int q=0;q<5;q++){
//      do{
//        do{
//          do{
//            valid=true;
//            System.out.print("Choose the coordinates to place the ");
//            System.out.print(unit[q]+"-unit ship with A1A5 form : ");
//            place = cin.next();
//            try{
//              placeCheck();
//            }
//            catch(){ //place ship exception
//              valid=false;
//              System.out.print(temp);
//            }
//          }
//        }
//      }
//    }
  }//place ship function ends
  //placing validation
  //missing validation function
  
  
  //start fucntion to call the other default functions 
  public void start(Game o){
    
  }//start function ends
  //player fire function
  void fire(Game o){
    
  }//start function ends
  //AI fire function
  void fire(Game o, int a){
    //delay function missing
    
    //reset
    o.done=false;
    for(int i=0;i<4;i++){
      o.cross[i]=true;
    }
    
    //fire logic start
    do{
      //debug helper
      aidbg(o);
      
    }while(done);
  }//ai fire function ends
  
  //ai logic debug helper
  void aidbg(Game o){
    System.out.println(o.crossdone+" "+o.finish+" "+o.goback+" "+
                       o.oppcombo+" "+o.combo);
  }
  //check player table (test game over)
  void check(){
    
  }//check player table function ends
  //check ai table(test game over)
  void check(Game o){
    
  }//check ai table fucntion ends
}
