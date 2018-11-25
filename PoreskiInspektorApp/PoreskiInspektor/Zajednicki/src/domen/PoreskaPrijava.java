/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Milica
 */
public class PoreskaPrijava implements Serializable{
    
    private int prijavaID;
    private int godina;
    private PoreskiObveznik po;
    private PoreskiInspektor pi;
    private ArrayList<StavkaPoreskePrijave> listaStavki;

    public PoreskaPrijava() {
    }

    public PoreskaPrijava(int prijavaID, int godina, PoreskiObveznik po, PoreskiInspektor pi, ArrayList<StavkaPoreskePrijave> listaStavki) {
        this.prijavaID = prijavaID;
        this.godina = godina;
        this.po = po;
        this.pi = pi;
        this.listaStavki = listaStavki;
    }

   

    public PoreskiInspektor getPi() {
        return pi;
    }

    public void setPi(PoreskiInspektor pi) {
        this.pi = pi;
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public PoreskiObveznik getPo() {
        return po;
    }

    public void setPo(PoreskiObveznik po) {
        this.po = po;
    }

    public ArrayList<StavkaPoreskePrijave> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaPoreskePrijave> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
    
    
}
