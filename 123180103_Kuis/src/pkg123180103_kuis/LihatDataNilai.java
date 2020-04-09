/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123180103_kuis;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author HP
 */
public class LihatDataNilai extends JFrame{
    String[][] data = new String [500][8];//buat variabel data kebentuk array;
    String[] kolom = {"Nim","Nama","Matkul 1","Nilai 1","Matkul 2","Nilai 2","Rata-rata","Huruf"};//disesuaikan dengan kolom yang diinginkan
    JTable tabel ;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    
    public void Lihatdata(){
        setTitle("Data Nilai Mahasiswa");
        try{
            Koneksi con = new Koneksi();
            statement = con.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM mhs";//perintah mengambil data
            resultSet = statement.executeQuery(sql);//data disimpan di reultSet
            
            int p = 0 ;
            while (resultSet.next()){
                //disesuaikan dengan kolom sesuai dengan di DB
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("nim");
                data[p][2] = resultSet.getString("mat1");
                data[p][3] = resultSet.getString("nilai1");
                data[p][4] = resultSet.getString("mat2");
                data[p][5] = resultSet.getString("nilai2");
                data[p][6] = resultSet.getString("rata2");
                data[p][7] = resultSet.getString("huruf");
                p++;
            }
            statement.close();
            con.getKoneksi().close();
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(rootPane, "Data Gagal ditampilkan"+sqle);
        } catch (ClassNotFoundException classe){
            JOptionPane.showMessageDialog(rootPane, "Class tidak ditemukan"+classe);
        }
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
        
        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}

