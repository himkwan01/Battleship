/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshiptry;

/**
 *
 * @author Jasmine
 */
public class BattleshipTRY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               IntroMenu menu = new IntroMenu();
               menu.setVisible(true);
               menu.setResizable(false);
            }
        });
      
    }
    
}
