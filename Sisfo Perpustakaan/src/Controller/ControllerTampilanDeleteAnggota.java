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
import sisfo.perpustakaan.*;
import view.*;

/**
 *
 * @author rizky
 */
public class ControllerTampilanDeleteAnggota implements ActionListener{
    private AnggotaModel model;
    private TampilanDeleteAnggota  view;
    private Anggota a;
    
    public ControllerTampilanDeleteAnggota(AnggotaModel model, Anggota a){
        this.model = model;
        view = new TampilanDeleteAnggota();
        view.setVisible(true);
        view.addListener(this);
        this.a = a;
        view.getBtnBack().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        database db = new database();
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnBack())){
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota();
            
        }
        else if (source.equals(view.getBtnDelete())){
            try {
                model.deleteAnggota();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAnggotaAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota();
            
            
        }
        else if (source.equals(view.getBtnDelete())){
            ControllerLogoutPetugas clp = new ControllerLogoutPetugas();
        }
    }
}

