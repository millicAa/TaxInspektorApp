/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class PoreskiInspektor implements Serializable{
    private int inspektorID;
    private String imePrezime;
    private String korisnickoIme;
    private String lozinka;

    public PoreskiInspektor() {
    }

    public PoreskiInspektor(int inspektorID, String imePrezime, String korisnickoIme, String lozinka) {
        this.inspektorID = inspektorID;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getInspektorID() {
        return inspektorID;
    }

    public void setInspektorID(int inspektorID) {
        this.inspektorID = inspektorID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    
}
