/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author bonfissuto_luca
 */
public class GestionePacchetti {

    Condivisa condivisa;

    public GestionePacchetti(Condivisa condivisa) {
        this.condivisa = condivisa;
    }

    public void invia_pacchetto(String indirizzo_ip, String azione, String contenuto) throws UnknownHostException, IOException {
        String messaggio = azione + ";" + contenuto;
        condivisa.setBuffer(messaggio.getBytes());
        condivisa.setPacket(new DatagramPacket(condivisa.getBuffer(), condivisa.getBuffer().length));
        InetAddress indirizzo = InetAddress.getByName(indirizzo_ip);
        condivisa.getPacket().setAddress(indirizzo);
        condivisa.getPacket().setPort(condivisa.getSender_port());
        condivisa.getSender().send(condivisa.getPacket());
    }

    public void controlla_pacchetto() throws IOException {
        condivisa.getReceiver().receive(condivisa.getPacket());
        String str = new String(condivisa.getPacket().getData());
        System.out.println(str);
        String[] campi = str.split(";");
        if (campi[0].equals("a") && condivisa.isOccupato() == false) {
            if (condivisa.getC().messaggio(campi[1], true) == 0) {
                Connessione conn = new Connessione();
                invia_pacchetto(condivisa.getPacket().getAddress().toString().substring(1), "y", conn.getNome());
                condivisa.setOccupato(true);
                condivisa.getC().setVisible(false);
                condivisa.setChat(campi[1].trim());
                condivisa.getChat().show();
            } else {
                condivisa.getC().messaggio("Hai rifiutato " + campi[1], false);
                invia_pacchetto(condivisa.getPacket().getAddress().toString().substring(1), "n", "");
            }
        } else if (campi[0].equals("y")) {
            condivisa.setOccupato(true);
            condivisa.getC().setVisible(false);
            condivisa.setChat(campi[1].trim());
            condivisa.getChat().show();
        } else if (campi[0].equals("n")) {
            condivisa.setOccupato(false);
            condivisa.getC().messaggio("il mittente ha rifiutato il messaggio", false);
            condivisa.reset_port(condivisa.getReceiver(), 12346);
        } else if (campi[0].equals("m")) {

        } else {
            // ritorna messaggio di no
            System.out.println(campi[1] + " ha provato a contattarti mentre eri occupato");
            invia_pacchetto(condivisa.getPacket().getAddress().toString().substring(1), "n", "");
        }
    }

}
