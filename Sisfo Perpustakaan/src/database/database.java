/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import sisfo.perpustakaan.Anggota;
import sisfo.perpustakaan.Aplikasi;
import sisfo.perpustakaan.Buku;
import sisfo.perpustakaan.Peminjaman;

public class database {

    private Statement stat;
    private Connection conn;
    private ResultSet rs;

    public database() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "");
            stat = conn.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ResultSet insertAnggota(Anggota a) {
        database db = new database();
        String SQLString = "insert into anggota values(" + a.getNim() + ",'" + a.getNama() + "','" + a.getJenisKelamin() + "','" + a.getJurusan() + "','" + a.getKelas() + "','" + a.getThnmasuk() + "','" + a.getPassword() + "')";
        return db.getData(SQLString);
    }

    public ResultSet getAnggota(String nim) {
        database db = new database();
        String SQLString = "select * from anggota where nim =" + nim;
        return db.getData(SQLString);
    }

    public ResultSet updateAngota(Anggota a) {
        database db = new database();
        String s = "update anggota set nama= '" + a.getNama() + "', Jenis_kelamin= '" + a.getJenisKelamin() + "', Jurusan= '" + a.getJurusan() + "', Kelas= '" + a.getKelas() + "', Tahun_Masuk= '" + a.getThnmasuk() + "' Password= '" + a.getPassword() + "' where nim= '" + a.getNim();
        return db.getData(s);
    }

    public ResultSet deleteAnggota(String nim) {
        database db = new database();
        String SQLString = "delete from anggota where nim =" + nim;
        return db.getData(SQLString);
    }

    public ResultSet displayAnggota() {
        database db = new database();
        String SQLString = "select * from anggota";
        return db.getData(SQLString);
    }

    public ResultSet insertBuku(Buku b) {
        database db = new database();
        String SQLString = "insert into anggota values(" + b.getIdBuku() + ",'" + b.getJudul() + "','" + b.getPengarang() + "','" + b.getTipe() + "','" + b.getThnMasukBuku() + "','" + b.getStatus() + "')";
        return db.getData(SQLString);
    }

    public ResultSet getBuku(String idBuku) {

        database db = new database();
        String SQLString = "select * from buku where id_buku =" + idBuku;
        return db.getData(SQLString);

    }

    public ResultSet updateBuku(Buku b) {
        database db = new database();
        String s = "update anggota set judul= '" + b.getJudul() + "', Pengarang= '" + b.getPengarang()+ "', Tipe= '" + b.getTipe()+ "', Tahun= '" + b.getThnMasukBuku() + "', Status= '" + b.getStatus()+ "' where id_buku= '" + b.getIdBuku();
        return db.getData(s);
    }

    public ResultSet deleteBuku(String idBuku) {
        database db = new database();
        String SQLString = "delete from buku where id_buku =" + idBuku;
        return db.getData(SQLString);
    }

    public ResultSet displayBuku() {
        database db = new database();
        String SQLString = "select * from buku";
        return db.getData(SQLString);
    }
    public ResultSet insertPeminjaman(Peminjaman p){
        database db = new database();
        String s ="insert into peminjaman values(" + p.getIdPeminjaman() + ",'" + p.getStatusPeminjaman()+ "','" + p.getPetugas(9).getId() + "','" + p.getAnggota(null).getNim() + "','" + p.getBuku(null).getIdBuku()+"')";
        return db.getData(s);
    }
    public ResultSet updatePeminjaman(Peminjaman p) {
        database db = new database();
        String s = "update peminjaman set Status= '" + p.getStatusPeminjaman()+ "', id_petugas= '" + p.getPetugas(9).getId()+ "', id_Anggota= '" +p.getAnggota(null).getNim()+"' where id_peminjaman= '" + p.getIdPeminjaman();
        return db.getData(s);
    }

    public ResultSet deletePeminjaman(long id) {
        database db = new database();
        String SQLString = "delete from peminjaman where id_peminjaman =" + id;
        return db.getData(SQLString);
    }
     public ResultSet getPeminjaman(long id) {

        database db = new database();
        String SQLString = "select * from peminjaman where id_peminjaman =" + id;
        return db.getData(SQLString);

    }
     public ResultSet getPeminjaman(String nim){
         database db = new database();
         String s = "select judul from buku join peminjaman using(id_buku) where nim="+nim+"order by id_buku asc";
         return db.getData(s);
     }

    public ResultSet displayPeminjaman() {
        database db = new database();
        String SQLString = "select b.id_buku, b.judul, a.nim, a.nama,p.status_pinjam from buku b, anggota a, peminjaman p where b.id_buku=p.id_buku and a.nim=p.nim";
        return db.getData(SQLString);
    }

    public void query(String SQLString) {
        try {
            stat.executeUpdate(SQLString);
        } catch (Exception e) {
        }
    }

    public ResultSet getData(String SQLString) {
        try {
            rs = stat.executeQuery(SQLString);
        } catch (Exception e) {
        }
        return rs;
    }

    public String getQuote(String masuk) {
        return "'" + masuk + "'";
    }

    public ResultSet LoginAnggota(String u, String p) {
        database db = new database();
        String SQLString = "SELECT * from anggota where nim= " + getQuote(u) + " AND password = " + getQuote(p) + ";";
        return db.getData(SQLString);
    }

    public ResultSet LoginPetugas(String u, String p) {
        database db = new database();
        String SQLString = "SELECT * from petugas where id_petugas= " + getQuote(u) + " AND password = " + getQuote(p) + ";";
        return db.getData(SQLString);
    }

}
