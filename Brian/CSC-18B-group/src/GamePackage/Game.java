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
/**
 * 03/04/15
 * fixed AI fire function00
 * can add method to make type casting
 * char x = int x;  0123
 * char y = int y;  ABCD
 * @author Himkw_000
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
  public void print(AI o){
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
  public void Place(AI o){
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
  public void start(AI o){
    for(int i=0;i<10;i++){
      fire(o);
      fire(o, 0);
    }
  }//start function ends
  //player fire function
  void fire(AI o){
    System.out.println("Player fire function");
    int dum;
    System.out.println("intput an integer");
    dum=cin.nextInt();
  }//start function ends
  //AI fire function
  void fire(AI o, int a){
    System.out.println("AI fire function");
    //delay function missing
    
    //reset
    o.done=false;
    for(int i=0;i<4;i++){
      o.cross[i]=true;
    }
    
    //fire logic start
    do{
      //debug helper
      //o.aidbg();
      o.done=false;
      if(o.crossdone==true && o.finish==true && 
         o.goback==true && o.done==false && 
         o.oppcombo==0 && o.combo==0){
        //randon fire
        System.out.print("random fire\n");
        o.goback=true;
        do{
          System.out.print("inner loop(random fire)\n");
          valid=true;
  //        cout<<num<<endl;
          o.x=rand.nextInt(num);
  //        System.out.print("first rand\n");
          o.y=rand.nextInt(num);
  //        System.out.print("second rand\n");
  //        cout<<o.y<<" "<<o.x<<endl;
          if(real[o.y][o.x]=='O' || real[o.y][o.x]=='X'){
            valid=false;
            System.out.print("overlap\n");
          }
        }while(valid==false);
        o.cx=(char)(o.x+48);
        o.cy=(char)(o.y+65);
  //      System.out.print("ai fire");
        System.out.print(o.cy+o.cx+"\n");
        if(real[o.y][o.x]!=' '){
          real[o.y][o.x]='X';
          System.out.print("Hit!\n");
          o.hx=o.x;
          o.hy=o.y;
          o.bhit=true;
          o.crossdone=false;
          o.finish=false;
          o.combo=0;
          o.done=true;
          o.oneend=false;
          o.hit++;
        }
        else{
          real[o.y][o.x]='O';
          System.out.print("Miss...\n");
          o.done=true;
          o.miss++;
        }
      }
      //move after hit
      if(o.bhit==true && o.finish==false && 
         o.crossdone==false && o.combo==0 && 
         o.oppcombo==0 && o.done==false){
        do{
          System.out.print("random cross\n");
          o.y=o.hy;
          o.x=o.hx;
          //check cross rand
          o.hplan=rand.nextInt(4);
          if(o.hplan==0) o.y=o.hy-1;  //down
          if(o.hplan==1) o.y=o.hy+1;  //up
          if(o.hplan==2) o.x=o.hx-1;  //left
          if(o.hplan==3) o.x=o.hx+1;  //right
          System.out.println("hplan = "+o.hplan);
          //check over size
          if(o.y<0 || o.y>num-1 || o.x<0 || o.x>num-1){
            System.out.print("Out table\n");
            o.cross[o.hplan]=false;
          }
          else if(real[o.y][o.x]=='X' || real[o.y][o.x]=='O'){
            System.out.print("overlap\n");
            o.cross[o.hplan]=false;
          }
          if(o.cross[0]==o.cross[1] && o.cross[1]==o.cross[2] && 
             o.cross[2]==o.cross[3] && o.cross[0]==false){
            System.out.print("test all 4 but invalid\n");
            o.crossdone=true;
            o.finish=true;
            o.goback=true;
          }
        }while(o.crossdone==false && o.cross[o.hplan]==false);
        //valid
        if(o.crossdone==false){
          System.out.print("check hit or miss by cross rand xy\n");
          o.cx=(char)(o.x+48);
          o.cy=(char)(o.y+65);
          System.out.print("ai fire ");
          System.out.println(o.cy+o.cx);
          if(real[o.y][o.x]!=' '){
            real[o.y][o.x]='X';
            System.out.print("Hit!\n");
            o.done=true;
            o.combo++;
            o.crossdone=true;
            o.hit++;
          }
          else{
            real[o.y][o.x]='O';
            System.out.print("Miss...\n");
            o.done=true;
            o.miss++;
          }
        }
        else{
          System.out.print("crossdone=true, go back to rand\n");
          o.goback=true;
        }
      }
      else if(o.combo>0 && o.oneend==false && 
              o.done==false && o.crossdone==true){
        System.out.print("Second hit\n");
        valid=true;
        if(o.hx==o.x){
          System.out.print("same x\n");
          if(o.hy>o.y) o.y=o.hy-o.combo-1;
          else         o.y=o.hy+o.combo+1;
          if(o.y<0 || o.y >num-1){
              valid=false;
          }
          if(valid==true){
            if(real[o.y][o.x]=='X' || real[o.y][o.x]=='O'){
              valid=false;
            }
            if(real[o.y][o.x]=='O'){
              o.finish=true;
              o.goback=true;
              o.crossdone=true;
              o.combo=0;
              o.oppcombo++;
              o.oneend=true;
            }
            if(valid==true){
              o.cx=(char)(o.x+48);
              o.cy=(char)(o.y+65);
  //            System.out.print("ai fire ");
              System.out.println(o.cy<<o.cx);
              if(real[o.y][o.x]!=' '){
                real[o.y][o.x]='X';
                System.out.print("Hit!!!\n");
                o.done=true;
                o.combo++;
                o.hit++;
              }
              else{
                real[o.y][o.x]='O';
                System.out.print("Miss...\n");
                o.done=true;
                o.oneend=true;
                o.oppcombo++;
                o.miss++;
              }
            }
          }
          else{ //check ->GO TO OPPCOMBO
            System.out.print("next xy invalid change to opposite side\n");
            o.combo=0;
            o.oneend=true;
            o.crossdone=true;
            o.oppcombo++;
            o.combohit=false;
          }
        }
        if(o.hy==o.y){
          System.out.print("same y\n");
          if(o.hx>o.x) o.x=o.hx-o.combo-1;
          else o.x=o.hx+o.combo+1;
          if(o.x<0 || o.x >num-1){
            valid=false;
            o.combo=0;
            o.goback=true;
            o.finish=true;
          }
          if(valid==true){
            if(real[o.y][o.x]=='X' || real[o.y][o.x]=='O'){
              valid=false;
              o.finish=true;
              o.goback=true;
            }
            if(valid==true){
              o.cx=(char)(o.x+48);
              o.cy=(char)(o.y+65);
  //            System.out.print("ai fire ");
              System.out.println(o.cy+o.cx);
              if(o.real[o.y][o.x]!=' '){
                o.real[o.y][o.x]='X';
                o.combo++;
                o.done=true;
                o.hit++;
              }
              else{
                real[o.y][o.x]='O';
                System.out.print("Miss...\n");
                o.done=true;
                o.oneend=true;
                o.oppcombo++;
                o.combo=0;
                o.combohit=false;
                System.out.print("oneend==true\n");
                System.out.print("done==true\n");
                o.miss++;
              }
            }
          }
          if(valid==false){ //GO TO OPPCOMBO
            System.out.print("next xy invalid change to other side\n");
            o.combo=0;
            o.oneend=true;
            o.crossdone=true;
            o.oppcombo++;
            o.combohit=false;
          }
        }
      }
      //check other side
      else if(o.oppcombo>0 && o.oneend==true && o.done==false){
        System.out.print("one side end check other side\n");
        System.out.println("oppcombo = "+o.oppcombo);
        if(o.hx==o.x){
          System.out.print("same x\n");
          if(o.combohit==false){
            if(o.hy>o.y) o.y=o.hy+o.oppcombo;
            else o.y=o.hy-o.oppcombo;
          }
          else{
            if(o.y>o.hy) o.y=o.hy+o.oppcombo;
            else o.y=o.hy-o.oppcombo;
          }
          System.out.println(o.y+o.x);
          if(o.y<0 || o.y>num-1 || o.real[o.y][o.x]=='O' || 
             real[o.y][o.x]=='X'){
            o.oppcombo=0;
            o.goback=true;
            o.finish=true;
            o.crossdone=true;
            o.combo=0;
            o.done=false;
            System.out.print("overlap or oversize\n");
          }
          else{
            o.cx=(char)(o.x+48);
            o.cy=(char)(o.y+65);
  //          System.out.print("ai fire ");
            System.out.println(o.cy+o.cx);
            if(real[o.y][o.x]!=' '){
              real[o.y][o.x]='X';
              System.out.print("Hit!!!\n");
              o.done=true;
              o.oppcombo+=1;
              o.combohit=true;
              o.hit++;
            }
            else{
              real[o.y][o.x]='O';
              System.out.print("Miss...\n");
              o.done=true;
              o.combo=0;
              o.oppcombo=0;
              o.finish=true;
              o.goback=true;
              o.crossdone=true;
              o.miss++;
            }
          }
        }
        else if(o.hy==o.y){
          System.out.print("same y\n");
          if(o.combohit==false){
            if(o.hx>o.x) o.x=o.hx+o.oppcombo;
            else o.x=o.hx-o.oppcombo;
          }
          else{
            if(o.x>o.hx) o.x=o.hx+o.oppcombo;
            else o.x=o.hx-o.oppcombo;
          }
          System.out.println(o.y+o.x);
          if(o.x<0 || o.x>num-1 || o.real[o.y][o.x]=='O' || 
             real[o.y][o.x]=='X'){
            o.oppcombo=0;
            o.goback=true;
            o.finish=true;
            o.crossdone=true;
            o.combo=0;
            o.done=false;
            System.out.print("overlap or oversize\n");
          }
          else{
            o.cx=(char)(o.x+48);
            o.cy=(char)(o.y+65);
  //          System.out.print("ai fire ");
            System.out.println(o.cy+o.cx);
            if(real[o.y][o.x]!=' '){
               real[o.y][o.x]='X';
              System.out.print("Hit!!!\n");
              o.done=true;
              o.oppcombo+=1;
              o.combohit=true;
              o.hit++;
            }
            else{
              real[o.y][o.x]='O';
              System.out.print("Miss...\n");
              o.done=true;
              o.combo=0;
              o.oppcombo=0;
              o.finish=true;
              o.goback=true;
              o.crossdone=true;
              o.miss++;
            }
          }
        }
      }
    }while(o.done==false);
    //print table
    print(o);
    //check player table
    check();
  }//ai fire function ends
  
  
  //check player table (test game over)
  void check(){
    
  }//check player table function ends
  //check ai table(test game over)
  void check(Game o){
    
  }//check ai table fucntion ends
}
