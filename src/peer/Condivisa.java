/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.swing.JFrame;

/**
 *
 * @author lucab
 */
public class Condivisa {
    private int sender_port;
    private int receiver_port;
    private DatagramSocket receiver;
    private DatagramSocket sender;
    private DatagramPacket packet;
    byte[] buffer;
    String ip;
    int dimensione;
    Connessione c;
    chat chat;
    boolean occupato;
    String IP;
    JFrame frame;
    String messaggio;

    public Condivisa(int dimensione, int r_port, int s_port) throws SocketException {
        this.dimensione = dimensione;
        receiver = new DatagramSocket(r_port);
        sender = new DatagramSocket(/*s_port*/);
        sender_port = s_port;
        receiver_port = r_port;
        buffer = new byte[this.dimensione];
        packet = new DatagramPacket(buffer, buffer.length);
        ip = "";
        c = new Connessione();
        chat = new chat("");
        occupato = false;
        IP = "";
        messaggio = "";
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = "";
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getIP() {
        return IP;
    }

    public synchronized boolean isOccupato() {
        return occupato;
    }

    public synchronized void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
    
    public synchronized void reset_port(DatagramSocket port, int n_port) throws SocketException{
        port.close();
        port = new DatagramSocket(n_port);
    }
    
    public synchronized void azzera_buffer() {
        buffer = new byte[this.dimensione];
    }

    public synchronized void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public synchronized byte[] getBuffer() {
        return buffer;
    }

     public synchronized DatagramSocket getReceiver() {
        return receiver;
    }

    public DatagramSocket getSender() {
        return sender;
    }
    
    public synchronized void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }

    public synchronized DatagramPacket getPacket() {
        return packet;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public Connessione getC() {
        return c;
    }

    public void setChat(String nome) {
        this.chat = new chat(nome);
    }
    public chat getChat() {
        return chat;
    }

    public int getSender_port() {
        return sender_port;
    }
}
