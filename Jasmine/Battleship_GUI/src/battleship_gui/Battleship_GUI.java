/*
 * File: Battleship_GUI
 * Programmer: Jasmine Anica
 * Class: CSC 18C
 * Date: 3/18/15
 */
package battleship_gui;

/**
 *
 * @author Jasmine
 */
public class Battleship_GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               JFrame_Battleship menu = new JFrame_Battleship();
               menu.setVisible(true);
               menu.setResizable(false);
            }
        });
      
    }
    
}
