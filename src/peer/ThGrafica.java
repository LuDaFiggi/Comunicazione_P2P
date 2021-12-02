/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bonfissuto_luca
 */
public class ThGrafica extends Thread{
    Condivisa condivisa;

    public ThGrafica(Condivisa condivisa) {
        this.condivisa = condivisa;
    }

    @Override
    public void run() {
        while(true){
            condivisa.getFrame().repaint();
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
