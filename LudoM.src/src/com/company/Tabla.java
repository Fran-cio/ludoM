package com.company;

import javax.swing.*;
import java.awt.*;

/*public class Tabla extends javax.swing.JFrame {

    private JPanel jPanel1;
    private JPanel jPanel12;


    public Tabla() {

        this.setBounds(0, 0, 1024, 720);
        this.setLocationRelativeTo(null);
        this.jPanel1.setBounds(0, 0, 1024, 720);
        this.jPanel1.setBackground(new java.awt.Color(190, 190, 190));


        this.jPanel12.setBounds(0, 0, 12, 12);
        this.jPanel12.setBackground(new java.awt.Color(100, 100, 100));

    }

}*/


public class Tabla extends JFrame{
    private JPanel jPanel1;
    public Tabla(){
        setSize(500,500);
        setTitle("asdasd");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200,200));
        this.getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        this.jPanel1.setBackground(new java.awt.Color(190, 190, 190));
    }

    private void iniciarComponentes(){


    }

}