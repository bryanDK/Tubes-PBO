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
import sisfo.perpustakaan.Aplikasi;
import view.AnggotaUpdate;
import view.Dashboard;

/**
 *
 * @author rizky
 */
public class ControllerDashboard implements ActionListener{
    private Aplikasi apk;
    private Dashboard  view;
    public ControllerDashboard(){
        view.getBtnAnggota().addActionListener(this);
        view.getBtnBuku().addActionListener(this);
        view.getBtnLogout().addActionListener(this);
        view.getBtnPeminjaman().addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        database db = new database();
        Object source = e.getSource();
        if (source.equals(view.getBtnAnggota())){
            ControllerDaftarAnggota cd = new ControllerDaftarAnggota();   
        }
        else if (source.equals(view.getBtnBuku())){
            ControllerDaftarBuku cd = new ControllerDaftarBuku();
            
        }
        else if (source.equals(view.getBtnPeminjaman())){
            ControllerDaftarPeminjaman cd = new ControllerDaftarPeminjaman();
            
        }
        else if (source.equals(view.getBtnLogout())){
            ControllerLoginPetugas cd = new ControllerLoginPetugas(apk);
            
        }
        
    }
    
    
    
}
