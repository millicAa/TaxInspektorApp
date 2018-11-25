/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;



import domen.PoreskaPrijava;
import domen.PoreskiInspektor;
import domen.PoreskiObveznik;
import domen.VrstaPoreza;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;


/**
 *
 * @author Milica
 */
public class ObradaZahteva extends Thread {

   
Socket socket;

    public ObradaZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while (true) {
            KlijentskiZahtev kz = primiZahtev();
            
            System.out.println("Operacija klijenta: " + kz.getOperacija());

            ServerskiOdgovor so = new ServerskiOdgovor();
            switch (kz.getOperacija()) {
                case 1:
                    String username = kz.getUsername();
                    String pass= kz.getPassword();
                    
                    ArrayList<PoreskiInspektor> lista = Kontroler.getInstanca().dajSvePoreskeInspektore();
                    boolean nasao = false;
                    for (PoreskiInspektor poreskiInspektor : lista) {
                        if(username.equals(poreskiInspektor.getKorisnickoIme()) && pass.equals(poreskiInspektor.getLozinka())){
                            PoreskiInspektor p = poreskiInspektor;
                            
                            nasao = true;
                            so.setPi(p);
                        }
                    }
                    so.setOdgovor(nasao);
                    
                    break;
                case 2: 
                    
                    ArrayList<VrstaPoreza> listaVrsti= new ArrayList<>();
                    ArrayList<PoreskiObveznik> listaObv = new ArrayList<>();
                    
                    listaVrsti = Kontroler.getInstanca().vratiVrste();
                    listaObv = Kontroler.getInstanca().vratiObveznike();
                    
                    so.setListaVrsti(listaVrsti);
                    so.setListaObveznika(listaObv);
                    
                    
                    
                    
                    break;
                case 3:
                    
                    
                    PoreskaPrijava pr= kz.getP();
                    
                    boolean uneo;
            try {
                uneo = Kontroler.getInstanca().unesiPrijavu(pr);
                if(uneo){
                        so.setOdgovor(true);
                    }else{
                        so.setOdgovor(false);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                    break;
                    
                    
                    
                    
                        

            }
            
          
            posaljiOdgovor(so);

        }

    }

    public KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kz;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
