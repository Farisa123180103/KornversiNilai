/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123180103_kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class Form extends JFrame{
    JLabel lnim,lnama,lmat1,lmat2,lnil1,lnil2;
    JTextField txnim,txnama,txmat1,txmat2,txnil1,txnil2;
    JButton convert;
    Statement statement;
    
    
    public void formnilai (){
        
        setTitle("From Hitung Nilai");
        
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lmat1 = new JLabel("Matkul 1");
        lmat2 = new JLabel("Matkul 2");
        lnil1 = new JLabel("Nilai 1");
        lnil2 = new JLabel("Nilai 2");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txmat1 = new JTextField("");
        txmat2 = new JTextField("");
        txnil1 = new JTextField("");
        txnil2 = new JTextField("");
        
        convert = new JButton("Convert");
        
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmat1);
        add(lmat2);
        add(lnil1);
        add(lnil2);
        add(txnim);
        add(txnama);
        add(txmat1);
        add(txmat2);
        add(txnil1);
        add(txnil2);
        add(convert);
        
        lnim.setBounds(75, 50, 30, 20);
        lnama.setBounds(75, 75, 50, 20);
        lmat1.setBounds(75, 100, 50, 20);
        lnil1.setBounds(75, 125, 50, 20);
        lmat2.setBounds(75, 150, 50, 20);
        lnil2.setBounds(75, 175, 50, 20);
        txnim.setBounds(150, 50, 150, 20);
        txnama.setBounds(150, 75, 150, 20);
        txmat1.setBounds(150, 100, 150, 20);
        txnil1.setBounds(150, 125, 150, 20);
        txmat2.setBounds(150, 150, 150, 20);
        txnil2.setBounds(150, 175, 150, 20);
        convert.setBounds(150, 230, 100, 20);
        
        setSize(420,350); //untuk luas jendela
        
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        convert.addActionListener(new ActionListener() {//aksi untuk tombol convert
            @Override
            public void actionPerformed(ActionEvent e) {//event handling
                try {//kode program yang mungkin dpt menimbulkan exception
                int a1 =  Integer.parseInt(txnim.getText());
                String a2 = txnama.getText();
                String a3 = txmat1.getText();
                int a4 =  Integer.parseInt(txnil1.getText());
                String a5 = txmat2.getText();
                int a6 =  Integer.parseInt(txnil2.getText());
                float a7 = (float)((a4+a6)/2.0);
                String huruf = convertRata2KeHuruf(a7);
                Koneksi con = new Koneksi();
                    try {
                        statement = con.getKoneksi().createStatement();
                        //perintah insert
                        statement.executeUpdate("INSERT INTO mhs VALUES ('" 
                                + a2 + "','" + a1 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "','" + a7 + "','" + huruf +"')");
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) {//utk menangkap error
                        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                System.out.println("NIM = "+a1);
                System.out.println("Nama = "+a2);
                System.out.println("Matkul 1 = "+a3);
                System.out.println("Matkul 2 = "+a5);
                System.out.println("Rata2 = "+a7);
                System.out.println("Nilai Huruf = "+huruf);
                    
                } catch (NumberFormatException ex) {// utk menangkap exception
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");//menampilkan message dialog "Tipe data salah"
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                 
                }
                
                
                
                
            }
            private String convertRata2KeHuruf(float a7) {//untuk mengkonvert nilai rata2 ke huruf
               
               if (a7 >=80 && a7 <=100) return "A";
               else if (a7 >=75 && a7 < 80) return "B+";
               else if (a7 >=65 && a7 < 75) return "B";
               else if (a7 >=60 && a7 < 65) return "C+";
               else if (a7 >=50 && a7 < 60) return "C";
               else if (a7 >=20 && a7 < 50) return "D";
               else if (a7 >=0 && a7 < 20) return "E";
               else return "Error";
            }
            
        });
    }
}
