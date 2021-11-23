/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria_comunicazione.p2p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author lucab
 */
public class Condivisa {
    private DatagramSocket receiver;
    private DatagramPacket packet;
    byte[] buffer;
    String ip;

    public Condivisa(int dimensione) throws SocketException {
        receiver = new DatagramSocket(12345);
        buffer = new byte[dimensione];
        packet = new DatagramPacket(buffer, buffer.length);
        ip = "";
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
    
    
    
    
}
