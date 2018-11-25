/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import niti.NitZaustavi;

/**
 *
 * @author Milica
 */
public class PokretanjeServera extends Thread {
    private ServerSocket socket;
    
    public PokretanjeServera() {

    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("*********************");
            System.out.println("Uspesno pokrenut server");
            System.out.println("*************************");
//            gsf.postaviLabeluPokrenut();

            niti.NitZaustavi nz = new NitZaustavi(this, ss);
            nz.start();

            while (true) {
                Socket socket = ss.accept();

                System.out.println("Uspesno povezan sa klijentom");

                ObradaZahteva oz1 = new ObradaZahteva(socket);
                oz1.start();
//               
            }

        } catch (IOException ex) {
            System.out.println("Zaustavljen server");
//            gsf.postaviLabeluKraj();
        }

    }

    public ServerSocket getSocket() {
        return socket;
    }

    public void setSocket(ServerSocket socket) {
        this.socket = socket;
    }

   

}
