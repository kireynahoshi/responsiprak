/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsiprak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author II
 */
public class Home_P extends JFrame{
    
    JTextArea ta = new JTextArea("Selamat Datang."
            + "Silahkan Masuk ke menu gaji untuk melakukan perhitungan gaji."
            + "Jika mengalami kesulitan, klik menu petunjuk");
    JLabel linfo4 = new JLabel ("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    JButton btnHome = new JButton("HOME");
    JButton btnGaji = new JButton("GAJI");
    JButton btnData = new JButton("DATA");
    JButton btnInformasi = new JButton("INFORMASI");
    JButton btnAdmin = new JButton("ADMIN");
    
    Home_P(){
        //background
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
	setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
         
        add(ta);
        add(linfo4);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnInformasi);
        add(btnAdmin);
        
        setVisible(true);
        ta.setBounds(160,100,300,160);
        linfo4.setBounds(160,300,600,30);
        btnHome.setBounds(20,20,100,60);
        btnGaji.setBounds(20,90,100,60);
        btnData.setBounds(20,160,100,60);
        btnInformasi.setBounds(20,230,100,60);
        btnAdmin.setBounds(470,20,100,60);   
        
        btnHome.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Home_P Home_P;
                  Home_P = new Home_P();
                  MVC mvc = new MVC();
                  dispose();
              }
        });
        
        btnGaji.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Gaji_P Gaji_P;
                  Gaji_P = new Gaji_P();
                  MVC mvc = new MVC();
                  dispose();
              }
         });
        
        btnData.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  VData_P VData_P;
                  VData_P = new VData_P();
                  MVC mvc = new MVC();
                  dispose();
              }
         });
        
        btnInformasi.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Informasi_P Informasi_P;
                  Informasi_P = new Informasi_P();
                  dispose();
              }
         });
        btnAdmin.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  /*login_A*/
                  Login_A Login_A; 
                  Login_A = new Login_A();
              }
         });
    }

}