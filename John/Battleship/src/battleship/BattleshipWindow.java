
package battleship;

/**
 *
 * @author jdecker
 */
public class BattleshipWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               BattleshipFrame menu = new BattleshipFrame();
               menu.setVisible(true);
               menu.setResizable(false);
            }
        });
      
    }
    
}
