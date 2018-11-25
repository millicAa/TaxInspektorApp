/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocna;

/**
 *
 * @author Milica
 */
public class PomocnaKlasa {
    private int obveznikID;
    private String naziviliime;
    private String tip;
    private int godina;
    private double poreskidug;

    public PomocnaKlasa() {
    }

    public PomocnaKlasa(int obveznikID, String naziviliime, String tip, int godina, double poreskidug) {
        this.obveznikID = obveznikID;
        this.naziviliime = naziviliime;
        this.tip = tip;
        this.godina = godina;
        this.poreskidug = poreskidug;
    }

    public double getPoreskidug() {
        return poreskidug;
    }

    public void setPoreskidug(double poreskidug) {
        this.poreskidug = poreskidug;
    }

    public int getObveznikID() {
        return obveznikID;
    }

    public void setObveznikID(int obveznikID) {
        this.obveznikID = obveznikID;
    }

    public String getNaziviliime() {
        return naziviliime;
    }

    public void setNaziviliime(String naziviliime) {
        this.naziviliime = naziviliime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
    
    
            
}
