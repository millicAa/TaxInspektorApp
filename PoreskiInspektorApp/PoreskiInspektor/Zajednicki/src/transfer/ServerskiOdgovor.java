/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;


import domen.PoreskiInspektor;
import domen.PoreskiObveznik;
import domen.VrstaPoreza;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Milica
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private Object odgovor;
    private ArrayList<VrstaPoreza> listaVrsti;
    private ArrayList<PoreskiObveznik> listaObveznika;
    private PoreskiInspektor pi;

    public ServerskiOdgovor() {
        listaObveznika = new ArrayList<>();
        listaVrsti = new ArrayList<>();
    }

    public ServerskiOdgovor(String poruka, Object odgovor) {
        this.poruka = poruka;
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public PoreskiInspektor getPi() {
        return pi;
    }

    public void setPi(PoreskiInspektor pi) {
        this.pi = pi;
    }

    public ArrayList<VrstaPoreza> getListaVrsti() {
        return listaVrsti;
    }

    public void setListaVrsti(ArrayList<VrstaPoreza> listaVrsti) {
        this.listaVrsti = listaVrsti;
    }

    public ArrayList<PoreskiObveznik> getListaObveznika() {
        return listaObveznika;
    }

    public void setListaObveznika(ArrayList<PoreskiObveznik> listaObveznika) {
        this.listaObveznika = listaObveznika;
    }
   
    
  
  
    
}
