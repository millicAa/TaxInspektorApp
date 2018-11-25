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
public class VrstaPoreza implements Serializable{
    private int vrstaID;
    private String naziv;
    private int procenaPoreza;

    public VrstaPoreza() {
    }

    public VrstaPoreza(int vrstaID, String naziv, int procenaPoreza) {
        this.vrstaID = vrstaID;
        this.naziv = naziv;
        this.procenaPoreza = procenaPoreza;
    }

    public int getProcenaPoreza() {
        return procenaPoreza;
    }

    public void setProcenaPoreza(int procenaPoreza) {
        this.procenaPoreza = procenaPoreza;
    }

    public int getVrstaID() {
        return vrstaID;
    }

    public void setVrstaID(int vrstaID) {
        this.vrstaID = vrstaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
