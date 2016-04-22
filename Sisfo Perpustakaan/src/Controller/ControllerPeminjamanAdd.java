/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BukuModel;
import model.PeminjamanModel;
import sisfo.perpustakaan.Buku;
import sisfo.perpustakaan.Peminjaman;
import view.BukuAdd;
import view.PeminjamanAdd;

/**
 *
 * @author rizky
 */
public class ControllerPeminjamanAdd implements ActionListener{
    private PeminjamanModel model;
    private PeminjamanAdd  view;
    private Peminjaman pj;
    
    public ControllerPeminjamanAdd(PeminjamanModel model, Peminjaman pj){
        this.model = model;
        view = new PeminjamanAdd();
        view.setVisible(true);
        view.addListener(this);
        this.pj = pj;
        view.settIdPeminjaman(pj.getIdPeminjaman());
        view.settIdBuku(pj.getBuku().getId());
        view.settPengarang(b.getPengarang());
        view.settTipe(b.getTipe());
        view.settTahun(b.getThnMasukBuku());
        view.settIdBuku(b.getIdBuku());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
