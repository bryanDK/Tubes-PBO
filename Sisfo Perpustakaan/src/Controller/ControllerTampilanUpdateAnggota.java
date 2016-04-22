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
import sisfo.perpustakaan.Anggota;
import view.*;

/**
 *
 * @author rizky
 */
public class ControllerTampilanUpdateAnggota implements ActionListener{
    private AnggotaModel model;
    private TampilanUpdateAnggota  view;
    private Anggota a;
    
    public ControllerTampilanUpdateAnggota(AnggotaModel model, Anggota a){
        this.model = model;
        view = new TampilanUpdateAnggota();
        view.setVisible(true);
        view.addListener(this);
        this.a = a;
        view.settIdAnggota(a.getNim());
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        database db = new database();
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnBack())){
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota(a);
            
        }
        else if (source.equals(view.getBtnInput())){
            try {
                model.deleteAnggota();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAnggotaAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota(a);
            
            
        }
        else if (source.equals(view.getBtnLogout())){
            ControllerLogoutPetugas clp = new ControllerLogoutPetugas();
        }
    }
}
