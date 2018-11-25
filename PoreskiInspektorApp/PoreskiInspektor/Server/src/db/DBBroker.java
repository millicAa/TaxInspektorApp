/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.FizickoLice;
import domen.PoreskaPrijava;
import domen.PoreskiInspektor;
import domen.PoreskiObveznik;
import domen.PravnoLice;
import domen.StavkaPoreskePrijave;
import domen.VrstaPoreza;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pomocna.PomocnaKlasa;

/**
 *
 * @author Milica
 */
public class DBBroker {

    Connection konekcija;

    public DBBroker() {
    }

    public void ucitajDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public void ucitajKonekciju() throws SQLException {
        konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoftjun18predrok", "root", "jelena");
        konekcija.setAutoCommit(false);
        System.out.println("Uspesna konekcija");
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void commit() throws SQLException {
        konekcija.commit();
    }

    public void rollback() throws SQLException {
        konekcija.rollback();

    }

    public ArrayList<PoreskiInspektor> vratiPoreskeInspektore() throws SQLException {

        ArrayList<PoreskiInspektor> lista = new ArrayList<>();

        String upit = "SELECT * FROM poreskiinspektor";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            int id = rs.getInt("InspektorID");
            String imePRezime = rs.getString("ImePrezime");
            String korime = rs.getString("KorisnickoIme");
            String lozinka = rs.getString("Lozinka");

            PoreskiInspektor p = new PoreskiInspektor(id, imePRezime, korime, lozinka);
            lista.add(p);

        }
        return lista;

    }

    public ArrayList<PoreskiObveznik> vratiObveznike() throws SQLException {

        ArrayList<PoreskiObveznik> lista = new ArrayList<>();

        ArrayList<PravnoLice> listaPravnih = vratiPravna();
        ArrayList<FizickoLice> listaFizickih = vratiFizicka();

        for (FizickoLice fizickoLice : listaFizickih) {
            PoreskiObveznik p = new PoreskiObveznik(fizickoLice.getPo(), fizickoLice, null, false, true);
            lista.add(p);
        }
        for (PravnoLice pravnoLice : listaPravnih) {
            PoreskiObveznik p = new PoreskiObveznik(pravnoLice.getPo(), null, pravnoLice, true, false);
            lista.add(p);
        }

        return lista;

    }

    public ArrayList<VrstaPoreza> vratiVrste() throws SQLException {
        ArrayList<VrstaPoreza> lista = new ArrayList<>();

        String upit = "SELECT * FROM vrstaporeza";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            int id = rs.getInt("VrstaID");
            String naziv = rs.getString("Naziv");
            int procenat = rs.getInt("ProcenatPoreza");

            VrstaPoreza v = new VrstaPoreza(id, naziv, procenat);
            lista.add(v);

        }
        return lista;

    }

    private ArrayList<PravnoLice> vratiPravna() throws SQLException {
        ArrayList<PravnoLice> lista = new ArrayList<>();

        String upit = "SELECT * FROM poreskiobveznik p JOIN `pravnolice` f ON p.`ObveznikID` = f.`ObveznikID`";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);

        while (rs.next()) {
            int id = rs.getInt("ObveznikID");
            String PIB = rs.getString("PIB");

            String MaticniBroj = rs.getString("MaticniBroj");
            String Naziv = rs.getString("Naziv");

            PravnoLice p = new PravnoLice(id, PIB, MaticniBroj, Naziv);
            lista.add(p);

        }
        return lista;
    }

    private ArrayList<FizickoLice> vratiFizicka() throws SQLException {

        ArrayList<FizickoLice> lista = new ArrayList<>();

        String upit = "SELECT * FROM poreskiobveznik p JOIN fizickolice f ON p.`ObveznikID` = f.`ObveznikID`";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);

        while (rs.next()) {
            int id = rs.getInt("ObveznikID");
            String ime = rs.getString("ImePrezime");

            String jmbg = rs.getString("JMBG");

            FizickoLice f = new FizickoLice(id, jmbg, ime);
            lista.add(f);

        }
        return lista;
    }

    public int unesiPrijavu(PoreskaPrijava pr) throws SQLException {
        int id = -1;
        id = vratimaxPrijave();
        String upit = "INSERT INTO poreskaprijava VALUES(?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);

        ps.setInt(1, id);
        ps.setInt(2, pr.getGodina());
        ps.setInt(3, pr.getPo().getObveznikID());
        ps.setInt(4, pr.getPi().getInspektorID());
        ps.executeUpdate();

        return id;
    }

    public void unesiPrijavu(StavkaPoreskePrijave s, int rb) throws SQLException {

        String upit = "INSERT INTO stavkaporeskeprijave VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);

        ps.setInt(1, rb);
        ps.setInt(2, vratiMaxStavke());
        ps.setDate(3, new Date(s.getDatumPrometa().getTime()));
        ps.setDouble(4, s.getVrednost());
        ps.setString(5, s.getNapomena());
        ps.setInt(6, s.getV().getVrstaID());

        ps.executeUpdate();

    }

    private int vratimaxPrijave() throws SQLException {
        int id = -1;
        String upit = "SELECT MAX(PrijavaID) as max FROM poreskaprijava";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            id = rs.getInt("max");
        }
        return ++id;
    }

    private int vratiMaxStavke() throws SQLException {
        int id = -1;
        String upit = "SELECT MAX(RB) as max FROM stavkaporeskeprijave";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            id = rs.getInt("max");
        }
        return ++id;
    }

    public ArrayList<PomocnaKlasa> vratiPomocnu(String tip) throws SQLException {
        ArrayList<PomocnaKlasa> lista = new ArrayList<>();

        ArrayList<PomocnaKlasa> pomocnaFizicka = vratiFizickaPomocna(tip);
        ArrayList<PomocnaKlasa> pomocnaPravna = vratiPravnaPomocna(tip);

        if (tip.equals("")) {
            for (PomocnaKlasa p : pomocnaPravna) {
                lista.add(p);
            }
            for (PomocnaKlasa f : pomocnaFizicka) {
                lista.add(f);
            }
        }
        if (tip.equals("pravno")) {
            for (PomocnaKlasa p : pomocnaPravna) {
                lista.add(p);
            }
        }
        if (tip.equals("fizicko")) {
            {
                for (PomocnaKlasa f : pomocnaFizicka) {
                    lista.add(f);
                }
            }
            

        }
        return lista;
    }


    private ArrayList<PomocnaKlasa> vratiFizickaPomocna(String tipp) throws SQLException {
        ArrayList<PomocnaKlasa> lista = new ArrayList<>();
        String upit = "SELECT p.`ObveznikID` AS ObveznikID,f.`ImePrezime` AS ImePrezime, 'fizickolice' AS fizickolice, pr.`Godina` AS godina, (SUM(s.`Vrednost`)* v.`ProcenatPoreza`) AS dug FROM `poreskiobveznik` p JOIN `fizickolice` f ON f.`ObveznikID` = p.`ObveznikID` JOIN `poreskaprijava` pr ON pr.`ObveznikID`=p.`ObveznikID` JOIN `stavkaporeskeprijave` s ON pr.`PrijavaID` = s.`PrijavaID` JOIN `vrstaporeza` v ON v.`VrstaID` = s.`VrstaID` GROUP BY p.`ObveznikID`";
        Statement s = konekcija.createStatement();

        ResultSet rs = s.executeQuery(upit);

        while (rs.next()) {
            int id = rs.getInt("ObveznikID");
            String imePrez = rs.getString("ImePrezime");
            String tip = rs.getString("fizickolice");
            int godina = rs.getInt("godina");
            double dug = rs.getDouble("dug");

            PomocnaKlasa f = new PomocnaKlasa(id, imePrez, tip, godina, dug);
            lista.add(f);
        }
        return lista;
    }

    private ArrayList<PomocnaKlasa> vratiPravnaPomocna(String tipp) throws SQLException {
        ArrayList<PomocnaKlasa> lista = new ArrayList<>();
        String upit = "SELECT p.`ObveznikID` AS ObveznikID,f.`Naziv` AS ImePrezime, 'pravnolice' AS pravnolice, pr.`Godina` AS godina, (SUM(s.`Vrednost`)* v.`ProcenatPoreza`) AS dug FROM `poreskiobveznik` p JOIN `pravnolice` f ON f.`ObveznikID` = p.`ObveznikID` JOIN `poreskaprijava` pr ON pr.`ObveznikID`=p.`ObveznikID` JOIN `stavkaporeskeprijave` s ON pr.`PrijavaID` = s.`PrijavaID` JOIN `vrstaporeza` v ON v.`VrstaID` = s.`VrstaID` GROUP BY p.`ObveznikID`";
        Statement s = konekcija.createStatement();

        ResultSet rs = s.executeQuery(upit);

        while (rs.next()) {
            int id = rs.getInt("ObveznikID");
            String imePrez = rs.getString("ImePrezime");
            String tip = rs.getString("pravnolice");
            int godina = rs.getInt("godina");
            double dug = rs.getDouble("dug");

            PomocnaKlasa f = new PomocnaKlasa(id, imePrez, tip, godina, dug);
            lista.add(f);
        }
        return lista;

    }

}
