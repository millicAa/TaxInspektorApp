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
public class FizickoLice implements Serializable{
    private int po;
    private String jmbg;
    private String imePrezime;

    public FizickoLice() {
    }

    public FizickoLice(int po, String jmbg, String imePrezime) {
        this.po = po;
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

  

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

   
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    
}
