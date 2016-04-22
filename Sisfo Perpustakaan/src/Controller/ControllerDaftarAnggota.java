/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AnggotaModel;
import sisfo.perpustakaan.Anggota;
import sisfo.perpustakaan.Aplikasi;
import view.BukuAdd;
import view.DaftarAnggota;
import view.LoginPetugas;

/**
 *
 * @author LENOVO
 */
public class ControllerDaftarAnggota implements ActionListener {
    private Aplikasi apk;
    private AnggotaModel model;
    private DaftarAnggota view;
    private Anggota a;
    

    public ControllerDaftarAnggota(AnggotaModel model) {
        this.model = model;
        view = new DaftarAnggota();
        view.setVisible(true);
        view = new DaftarAnggota();
        view.setVisible(true);
        view.getBtnBack().addActionListener(this);
        view.getBtnAdd().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
        view.getBtnUpdate().addActionListener(this);
        view.getBtnLogout().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        AnggotaModel am = new AnggotaModel();
        
    }
}
