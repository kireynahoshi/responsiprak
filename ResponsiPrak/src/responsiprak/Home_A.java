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


public class Home_A extends JFrame{
    
    JLabel linfo1 = new JLabel ("Selamat Datang.");
    JLabel linfo2 = new JLabel ("Silahkan Masuk ke menu gaji untuk melakukan perhitungan gaji.");
    JLabel linfo3 = new JLabel ("Jika mengalami kesulitan, klik menu petunjuk");
    JLabel linfo4 = new JLabel ("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    JButton btnHome = new JButton("HOME");
    JButton btnGaji = new JButton("GAJI");
    JButton btnData = new JButton("DATA");
    JButton btnInformasi = new JButton("INFORMASI");
    JButton btnAdmin = new JButton("ADMIN");
    
    Home_A(){
        //background
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
	setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
         
        add(linfo1);
        add(linfo2);
        add(linfo3);
        add(linfo4);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnInformasi);
        add(btnAdmin);
        
        setVisible(true);
        linfo1.setBounds(160,100,200,20);
        linfo2.setBounds(160,130,600,20);
        linfo3.setBounds(160,160,600,20);
        linfo4.setBounds(160,300,600,30);
        btnHome.setBounds(20,20,100,60);
        btnGaji.setBounds(20,90,100,60);
        btnData.setBounds(20,160,100,60);
        btnInformasi.setBounds(20,230,100,60);
        btnAdmin.setBounds(470,20,100,60);   
        
        btnHome.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Home_A Home;
                  Home = new Home_A();
                  MVC mvc = new MVC();
                  dispose();
              }
        });
        
        btnGaji.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Gaji_P Gaji;
                  Gaji = new Gaji_P();
                  MVC mvc = new MVC();
                  dispose();
              }
         });
        
        btnData.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Data_A Data_A;
                  Data_A = new responsiprak.Data_A();
                  dispose();
              }
         });
        
        btnInformasi.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  MVC mvc = new MVC();
                  dispose();
              }
         });
    }

}