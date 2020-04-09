/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123180103_kuis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Koneksi {//mengoneksikan ke database
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{//utk menangkap yang error
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/db_kuis";
        Connection kon = (Connection) DriverManager.getConnection(url, "root", "");
        return kon;
    }
}
