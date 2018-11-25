/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.PokretanjeServera;

/**
 *
 * @author Milica
 */
public class NitZaustavi extends Thread {

    boolean kraj = false;
    PokretanjeServera ps;
    ServerSocket ss;

    public NitZaustavi(PokretanjeServera ps, ServerSocket ss) {
        this.ps = ps;
        this.ss = ss;
    }

    

   

    @Override
    public void run() {
        while(!kraj){
        if (ps.isInterrupted()) {

            try {
                kraj = true;
                ss.close();
                sleep(1000);
                System.out.println("Osvezio zaust");
            } catch (IOException ex) {
                Logger.getLogger(NitZaustavi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitZaustavi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }}
        
        
        if(kraj==true){
            System.out.println("Zaustavljen");
        }
    }

}
