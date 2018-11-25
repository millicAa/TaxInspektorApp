/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import niti.NitZaustavi;

import pomocna.PomocnaKlasa;
import server.PokretanjeServera;

/**
 *
 * @author Milica
 */
public class GlavnaForma implements Runnable {

    static Thread nit;

    @Override
    public void run() {
        boolean krajRada = false;
        try {

            boolean zaustavio = false;
            while (true) {
                PokretanjeServera ps = new PokretanjeServera();

                //prikazi();
                while (!krajRada) {
                    Scanner s = new Scanner(System.in);

                    System.out.println("****************************");

                    System.out.println("***Glavni meni***");
                    System.out.println("1.Pokreni server");
                    System.out.println("2.Zaustavi server");
                    System.out.println("3. Filtriraj po pravnom/fizickom licu");
                    System.out.println("4. Kraj rada");

                    System.out.println("Vas izbor(1-4): ");
                    int izbor = 0;
                    izbor = Integer.parseInt(s.nextLine());

                    if (izbor == 1) {
                        ps = new PokretanjeServera();
                        ps.start();

                    }
                    if (izbor == 2) {
                        ps.interrupt();
                        zaustavio = true;
                    }
                    if (izbor == 3) {
                        System.out.println("Unesite pravno ili fizicko:");
                        String tip = s.nextLine();
                        System.out.println("Izabrali ste filter " + tip);
                        prikazi(tip);

                    }
                    if (izbor == 4) {
                        ps.interrupt();
                        krajRada= true;
                        System.exit(0);
                        System.out.println("Kraj rada");

                  
                    }
                }

                sleep(3000);
                System.out.println("Osvezio");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
       
        nit = new Thread(new GlavnaForma());
        nit.start();

    }

    public static void prikazi(String tip) {
        if (tip.isEmpty()) {
            tip = "";
        }
        ArrayList<pomocna.PomocnaKlasa> lista = Kontroler.getInstanca().vratiListuPomocnu(tip);
        System.out.println("ObveznikID      Naziv/ImePrezime        Tio     Godina      PoreskiDug");
        for (PomocnaKlasa p : lista) {
            System.out.println(p.getObveznikID() + " " + p.getNaziviliime() + "  " + p.getTip() + "  " + p.getGodina() + "   " + p.getPoreskidug());
        }

    }

}
