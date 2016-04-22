/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import sisfo.perpustakaan.Anggota;
import sisfo.perpustakaan.Aplikasi;
import sisfo.perpustakaan.Buku;
import view.AnggotaAdd;
import view.BukuAdd;

/**
 *
 * @author rizky
 */
public class ControllerBukuAdd implements ActionListener{
    private Aplikasi apk;
    private BukuModel model;
    private BukuAdd  view;
    private Buku b;
    
    public ControllerBukuAdd(BukuModel model, Buku b){

        this.model = model;
        view = new BukuAdd();
        view.setVisible(true);
        view.getBtnBack().addActionListener(this);
        view.getBtnInput().addActionListener(this);
        view.getBtnLogout().addActionListener(this);
        this.b = b;
        view.settJudul(b.getJudul());
        view.settPengarang(b.getPengarang());
        view.settTipe(b.getTipe());
        view.settTahun(b.getThnMasukBuku());
        view.settIdBuku(b.getIdBuku());
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        database db = new database();
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            ControllerDaftarBuku cd = new ControllerDaftarBuku(null);
            
        }
        else if (source.equals(view.getBtnInput())){
            try {
                model.insertBuku();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAnggotaAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else if (source.equals(view.getBtnLogout())){
            ControllerLoginPetugas clp = new ControllerLoginPetugas(apk);
        }
    }
}
