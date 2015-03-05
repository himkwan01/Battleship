/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePackage;

/**
 *
 * @author Himkw_000
 */
public class AI extends Game{
  protected boolean done; //should in ai class change later
  protected int hplan;
  protected boolean[] cross = new boolean[4]; //four boxes beside hit coordinate
  protected boolean crossdone;
  protected boolean finish;
  protected boolean goback;
  protected int oppcombo;
  protected int combo;
  protected char cx, cy;
  protected boolean oneend;
  protected boolean combohit;
  protected boolean bhit;
  protected int hx, hy, x, y;  //last hit coordinate
  public AI(int x, char c){
    super(x, c);
    crossdone=true;
    finish=true;
    goback=true;
    done=false;
    oppcombo=0;
    combo=0;
    bhit=true;
    for(int i=0;i<4;i++)
          cross[i]=true;
  }
  //ai logic debug helper
  public void aidbg(){
    System.out.println(crossdone+" "+finish+" "+goback+" "+
                       oppcombo+" "+combo);
  }
}
