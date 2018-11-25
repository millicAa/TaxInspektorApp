/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;


import domen.PoreskaPrijava;
import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class KlijentskiZahtev implements Serializable{
    private int operacija;
    private Object parametar;
    private String username;
    private String password;
    private PoreskaPrijava p;
    
    
    
    

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PoreskaPrijava getP() {
        return p;
    }

    public void setP(PoreskaPrijava p) {
        this.p = p;
    }

  
   
    
    

   
    
}
