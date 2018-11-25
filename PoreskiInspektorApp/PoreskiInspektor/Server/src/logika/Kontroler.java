/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.PoreskaPrijava;
import domen.PoreskiInspektor;
import domen.PoreskiObveznik;
import domen.StavkaPoreskePrijave;
import domen.VrstaPoreza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocna.PomocnaKlasa;

/**
 *
 * @author Milica
 */
public class Kontroler {

    private static Kontroler instanca;

    DBBroker db;

    public Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ArrayList<PoreskiInspektor> dajSvePoreskeInspektore() {
        ArrayList<PoreskiInspektor> lista = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.ucitajKonekciju();
            lista = db.vratiPoreskeInspektore();
            db.zatvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<VrstaPoreza> vratiVrste() {
        ArrayList<VrstaPoreza> lista = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.ucitajKonekciju();
            lista = db.vratiVrste();
            db.zatvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public ArrayList<PoreskiObveznik> vratiObveznike() {
        ArrayList<PoreskiObveznik> lista = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.ucitajKonekciju();
            lista = db.vratiObveznike();
            db.zatvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public boolean unesiPrijavu(PoreskaPrijava pr) throws SQLException {
         try {
            db.ucitajDriver();
            db.ucitajKonekciju();
            
            int rb = db.unesiPrijavu(pr);
            
             for (StavkaPoreskePrijave s : pr.getListaStavki()) {
                 
                 db.unesiPrijavu(s,rb);
             }
             
             db.commit();
              db.zatvoriKonekciju();
             return true;
             
             
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollback();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollback();
            return false;
        }

    }
    
    public ArrayList<PomocnaKlasa> vratiListuPomocnu(String tip){
         ArrayList<PomocnaKlasa> lista = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.ucitajKonekciju();
            lista = db.vratiPomocnu(tip);
            db.zatvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
