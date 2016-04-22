/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.PeminjamanModel;
import sisfo.perpustakaan.Aplikasi;
import view.DaftarPeminjam;

/**
 *
 * @author LENOVO
 */
public class ControllerDaftarPeminjaman implements ActionListener {
    private Aplikasi apk;
    private DaftarPeminjam view;
    private PeminjamanModel model;

    public ControllerDaftarPeminjaman(PeminjamanModel model) {
        this.model = model;
        view = new DaftarPeminjam();
        view.setVisible(true);
        view.getBtnBack().addActionListener(this);
        view.getBtnAdd().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
        view.getBtnUpdate().addActionListener(this);
        view.getBtnLogout().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
