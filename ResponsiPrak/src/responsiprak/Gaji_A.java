/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsiprak;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author II
 */
public class Gaji_A extends JFrame{
    JLabel lUsername = new JLabel(" Username : ");
    JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel(" Password : ");
    JTextField tfPassword = new JTextField();
    JButton btnLogin = new JButton(" LOGIN ");
    JButton btnCancel = new JButton(" CANCEL ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Username", "Password"};
}

