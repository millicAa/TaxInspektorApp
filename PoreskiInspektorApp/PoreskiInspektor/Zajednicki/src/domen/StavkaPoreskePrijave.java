/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Milica
 */
public class StavkaPoreskePrijave implements Serializable{
    private int rb;
    private int  p;
    private double vrednost;
    private Date DatumPrometa;
    private VrstaPoreza v;
    private String napomena;

    public StavkaPoreskePrijave() {
    }

    public StavkaPoreskePrijave(int rb, int p, double vrednost, Date DatumPrometa, VrstaPoreza v, String napomena) {
        this.rb = rb;
        this.p = p;
        this.vrednost = vrednost;
        this.DatumPrometa = DatumPrometa;
        this.v = v;
        this.napomena = napomena;
    }

    

 

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

   

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public Date getDatumPrometa() {
        return DatumPrometa;
    }

    public void setDatumPrometa(Date DatumPrometa) {
        this.DatumPrometa = DatumPrometa;
    }

    public VrstaPoreza getV() {
        return v;
    }

    public void setV(VrstaPoreza v) {
        this.v = v;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
 
    
    
}
