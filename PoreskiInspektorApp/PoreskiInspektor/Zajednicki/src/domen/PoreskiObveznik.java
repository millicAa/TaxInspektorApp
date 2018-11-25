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
public class PoreskiObveznik implements Serializable{
    private int obveznikID;
    private FizickoLice f;
    private PravnoLice p;
    private boolean pravnoLice;
    private boolean FizickoLice;

    public PoreskiObveznik() {
    }

    public PoreskiObveznik(int obveznikID, FizickoLice f, PravnoLice p, boolean pravnoLice, boolean FizickoLice) {
        this.obveznikID = obveznikID;
        this.f = f;
        this.p = p;
        this.pravnoLice = pravnoLice;
        this.FizickoLice = FizickoLice;
    }

    


    public int getObveznikID() {
        return obveznikID;
    }

    public void setObveznikID(int obveznikID) {
        this.obveznikID = obveznikID;
    }

    public FizickoLice getF() {
        return f;
    }

    public void setF(FizickoLice f) {
        this.f = f;
    }

    public PravnoLice getP() {
        return p;
    }

    public void setP(PravnoLice p) {
        this.p = p;
    }

    public boolean isPravnoLice() {
        return pravnoLice;
    }

    public void setPravnoLice(boolean pravnoLice) {
        this.pravnoLice = pravnoLice;
    }

    public boolean isFizickoLice() {
        return FizickoLice;
    }

    public void setFizickoLice(boolean FizickoLice) {
        this.FizickoLice = FizickoLice;
    }

    @Override
    public String toString() {
        if(p == null){
            return f.getImePrezime();
        }
        if(f==null){
            return p.getNaziv();
        }
        return "0";
    }

  
    
            
    
}
