/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicazione_p2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria_comunicazione.p2p.Condivisa;

/**
 *
 * @author lucab
 */
public class ThRicevi extends Thread {

    Condivisa condivisa;

    public ThRicevi() throws SocketException {
        condivisa = new Condivisa(1500);
    }

    @Override
    public void run() {
        try {
            //condivisa.getReceiver().receive(condivisa.getPacket());
            condivisa.getReceiver().receive(condivisa.getPacket());
            System.out.println(condivisa.getPacket().getData());
        } catch (IOException ex) {
            Logger.getLogger(ThRicevi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
