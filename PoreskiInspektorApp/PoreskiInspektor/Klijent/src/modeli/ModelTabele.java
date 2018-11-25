/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaPoreskePrijave;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabele extends AbstractTableModel {
    ArrayList<StavkaPoreskePrijave> listaStavki;

    public ModelTabele(ArrayList<StavkaPoreskePrijave> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public ModelTabele() {
        listaStavki = new ArrayList<>();
    }

 
    
    
    @Override
    public int getRowCount() {
            return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return 5;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPoreskePrijave s =listaStavki.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return ++rowIndex;
            case 1: return sdf.format(s.getDatumPrometa());
            case 2: return s.getV().getNaziv();
            case 3: return s.getVrednost();
            case 4: return s.getNapomena();
            default:return "";
        }

    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "RB";
            case 1: return "Datum prometa";
            case 2: return "Naziv";
            case 3: return "Vrednost";
            case 4: return "Napomena";
            default:return "";
        }


    }

    public boolean dodajStavku(StavkaPoreskePrijave s) {
        listaStavki.add(s);
        fireTableDataChanged();
        return true;

    }

    public void obrisi(int red) {
        listaStavki.remove(red);
        fireTableDataChanged();

    }

    public ArrayList<StavkaPoreskePrijave> getListaStavki() {
        return listaStavki;
    }
    
    
}
