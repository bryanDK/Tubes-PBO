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
import model.AnggotaModel;
import model.PetugasModel;
import sisfo.perpustakaan.Anggota;
import sisfo.perpustakaan.Aplikasi;
import view.*;

/**
 *
 * @author rizky
 */
public class ControllerAnggotaAdd implements ActionListener{
    private Aplikasi apk;
    private AnggotaModel model;
    private AnggotaAdd  view;
    private Anggota a;
    
    public ControllerAnggotaAdd(AnggotaModel model, Anggota a){
        this.model = model;
        view = new AnggotaAdd();
        view.setVisible(true);
        view.getBtnBack().addActionListener(this);
        view.getBtnInput().addActionListener(this);
        view.getBtnLogout().addActionListener(this);
        this.a = a;
        view.settNIM(a.getNim());
        view.settNama(a.getNama());
        view.settKelas(a.getKelas());
        view.settJurusan(a.getJurusan());
        view.settTahun(a.getThnmasuk());
        view.settPassword(a.getPassword());
        view.setJenisKelamin(a.getJenisKelamin());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        database db = new database();
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota();
            System.out.println("bye");
        }
        else if (source.equals(view.getBtnInput())){
            try {
                model.insertAnggota();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAnggotaAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota();
            
            
        }
        else if (source.equals(view.getBtnLogout())){
            ControllerLoginPetugas cd = new ControllerLoginPetugas(apk);
        }
    }
}
