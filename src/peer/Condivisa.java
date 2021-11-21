/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author bonfissuto_luca
 */
public class Condivisa {

    private DatagramSocket receiver;
    private DatagramPacket packet;
    byte[] buffer;
    String ip;
    int dimensione;
    chat c;
    boolean occupato;

    public Condivisa(int dimensione) throws SocketException {
        this.dimensione = dimensione;
        receiver = new DatagramSocket(12345);
        buffer = new byte[this.dimensione];
        packet = new DatagramPacket(buffer, buffer.length);
        ip = "";
        c = new chat();
        occupato = false;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
    
    public void azzera_buffer() {
        buffer = new byte[this.dimensione];
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public DatagramSocket getReceiver() {
        return receiver;
    }

    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }

    public DatagramPacket getPacket() {
        return packet;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public chat getC() {
        return c;
    }

}
