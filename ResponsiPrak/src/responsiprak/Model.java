/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsiprak;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class Model {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsiprak";
    static final String USER = "root"; 
    static final String PASS = "";  
    
    Connection con;
    Statement stm;
    
    public Model(){
    try{
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil!");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }
    }
    
    public void insertPegawai(String id_pegawai, String nama, String posisi, String alamat, String no_hp, String gaji, String jam_lembur, String tunjangan, String pajak, String total_gaji){
    try{
        String query = "INSERT INTO `pegawai` (`id_pegawai`, `nama`, `posisi`, `alamat`, `no_hp`, `gaji`, `jam_lembur`, `tunjangan`, `pajak`, `total_gaji`) VALUES ('"+id_pegawai+"', '"+nama+"', '"+posisi+"', '"+alamat+"', '"+no_hp+"', '"+gaji+"', '"+jam_lembur+"', '"+tunjangan+"', '"+pajak+"', '"+total_gaji+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(SQLException | HeadlessException sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readPegawai(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataPegawai()][10];
        String query = "Select * from `pegawai`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("id_pegawai");
        data[jmlData][1] = resultSet.getString("nama");
        data[jmlData][2] = resultSet.getString("posisi");
        data[jmlData][3] = resultSet.getString("alamat");
        data[jmlData][4] = resultSet.getString("no_hp");
        data[jmlData][5] = resultSet.getString("gaji");
        data[jmlData][6] = resultSet.getString("jam_lembur");
        data[jmlData][7] = resultSet.getString("tunjangan");
        data[jmlData][8] = resultSet.getString("pajak");
        data[jmlData][9] = resultSet.getString("total_gaji");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataPegawai(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `pegawai`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }

public void deletePegawai (String id_pegawai){
    try{
    String query = "DELETE FROM `pegawai` WHERE `id_pegawai` = '"+id_pegawai+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
}

public void editPegawai(String id_pegawai,String nama,String posisi, String alamat, String no_hp,String gaji, String jam_lembur, String tunjangan, String pajak, String total_gaji) {                                         
       
        try {
      
 String query ="UPDATE `pegawai` SET `id_pegawai` = '"+id_pegawai+"', `nama` = '"+nama+"',`posisi` = '"+posisi+"',`alamat`= '"+alamat+"',`no_hp` = '"+no_hp+"',`gaji`= '"+gaji+"',`jam_lembur`= '"+jam_lembur+"',`tunjangan`= '"+tunjangan+"',`pajak`= '"+pajak+"',`total_gaji`= '"+total_gaji+"' "
         + "WHERE `id_pegawai` = '"+id_pegawai+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    }

public int getBanyakDataSearchPegawai(){
    int jmlData=0;
    try{
        stm = (Statement)con.createStatement();
        String query ="Select * from `pegawai`";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}

public String[][] searchPegawai(String id){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchPegawai()][10];
        String query = "SELECT*FROM `pegawai` WHERE `id_pegawai` LIKE '%" + id + "%' ORDER BY `id_pegawai` ASC ";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("id_pegawai");
            data[jmlData][1] = resultSet.getString("nama");
            data[jmlData][2] = resultSet.getString("posisi");
            data[jmlData][3] = resultSet.getString("alamat");
            data[jmlData][4] = resultSet.getString("no_hp");
            data[jmlData][5] = resultSet.getString("gaji");
            data[jmlData][6] = resultSet.getString("jam_lembur");
            data[jmlData][7] = resultSet.getString("tunjangan");
            data[jmlData][8] = resultSet.getString("pajak");
            data[jmlData][9] = resultSet.getString("total_gaji");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public void insertAdmin(String Username, String Password){
    try{
        String query = "INSERT INTO `admin` (`Usename`, `Password`) VALUES ('"+Username+"', '"+Password+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(SQLException | HeadlessException sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

public String[][] readAdmin(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataAdmin()][2];
        String query = "Select * from `admin`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("Username");
        data[jmlData][1] = resultSet.getString("Password");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }

public int getBanyakDataAdmin(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `pegawai`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }

public String[][] searchDataAdmin(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataAdmin()][6];
        String query = "Select * from `pegawai`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("id_pegawai");
        data[jmlData][1] = resultSet.getString("nama");
        data[jmlData][2] = resultSet.getString("alamat");
        data[jmlData][3] = resultSet.getString("no_hp");
        data[jmlData][4] = resultSet.getString("posisi");
        data[jmlData][5] = resultSet.getString("gaji");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }

public String[][] readDataAdmin(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataAdmin()][6];
        String query = "Select * from `pegawai`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("id_pegawai");
        data[jmlData][1] = resultSet.getString("nama");
        data[jmlData][2] = resultSet.getString("alamat");
        data[jmlData][3] = resultSet.getString("no_hp");
        data[jmlData][4] = resultSet.getString("posisi");
        data[jmlData][5] = resultSet.getString("gaji");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }

public void editDataAdmin(String id_pegawai,String nama,String alamat, String no_hp,String posisi, String gaji) {                                         
       
        try {
      
 String query ="UPDATE `pegawai` SET `id_pegawai` = '"+id_pegawai+"', `nama` = '"+nama+"',`alamat` = '"+alamat+"',`no_hp`= '"+no_hp+"',`posisi` = '"+posisi+"',`gaji`= '"+gaji+"'" 
         + "WHERE `id_pegawai` = '"+id_pegawai+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    }

public void deleteDataAdmin (String id_pegawai){
    try{
    String query = "DELETE FROM `pegawai` WHERE `id_pegawai` = '"+id_pegawai+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
}
}