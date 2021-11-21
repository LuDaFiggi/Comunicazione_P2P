/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.io.IOException;

/**
 *
 * @author bonfissuto_luca
 */
public class GestionePacchetti {

    Condivisa condivisa;

    public GestionePacchetti(Condivisa condivisa) {
        this.condivisa = condivisa;
    }

    public void controlla_pacchetto() throws IOException {
        condivisa.getReceiver().receive(condivisa.getPacket());
        //System.out.println();
        String str = new String(condivisa.getPacket().getData());
        String[] campi = str.split(";");
        if (campi[0].equals("a") && condivisa.isOccupato() == false) {
            if (condivisa.getC().messaggio(campi[1], true) == 0) {
                condivisa.setOccupato(true);
            } else {
                condivisa.getC().messaggio(campi[1], false);
            }
        } else {
            // ritorna messaggio di no
            System.out.println(campi[1] + " ha provato a contattarti mentre eri occupato");
        }
    }

}
