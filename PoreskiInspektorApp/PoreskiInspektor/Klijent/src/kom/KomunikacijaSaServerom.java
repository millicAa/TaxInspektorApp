/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kom;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class KomunikacijaSaServerom {

    private static KomunikacijaSaServerom kom;
    Socket socket;
  

    public KomunikacijaSaServerom() {
        try {
           socket = new Socket("localhost", 9000);
//            gkf.postaviPovezanostUspesno();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
          //  gkf.postaviPovezanostNeuspesno();
        }
            
    }

    

    public static KomunikacijaSaServerom getKom() {
        if (kom == null) {
            kom = new KomunikacijaSaServerom();
        }
        return kom;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) {
        ObjectOutputStream ous = null;
        try {
            ous = new ObjectOutputStream(socket.getOutputStream());
            ous.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServerskiOdgovor prihvatiOdgovor() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

}
