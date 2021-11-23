/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author bonfissuto_luca
 */
public class ThRicevi extends Thread {

    Condivisa condivisa;
    GestionePacchetti gp;

    public ThRicevi(Condivisa condivisa) throws SocketException {
        this.condivisa = condivisa;
        gp = new GestionePacchetti(condivisa);
    }

    @Override
    public void run() {
        while (true) {
            try {
                gp.controlla_pacchetto();
            } catch (IOException ex) {
                Logger.getLogger(ThRicevi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
