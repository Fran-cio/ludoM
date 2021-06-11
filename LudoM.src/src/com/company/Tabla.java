package com.company;

import javax.swing.*;
import java.awt.*;


public class Tabla extends JFrame{
  private JPanel tablero2;


    public Tabla(){

        this.setLayout(null);
        setTitle("Ludo Matic");
        setLocationRelativeTo(null);
        this.setResizable(false);
        setMinimumSize(new Dimension(200,200));
        setSize(800,800);
        this.getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.tablero2.setBounds(0, 0, 500, 500);
        this.tablero2.setBackground(new java.awt.Color(190, 190, 190));
        this.add(tablero2);
        this.tablero2.setVisible(false);


        JPanel[][] tablero1 = new JPanel[15][15];
    for(int i=0;i<15;i++){
        for (int j=0; j<15;j++){
            tablero1[i][j]=new JPanel();
            tablero1[i][j].setBounds((i+1)*40,(j+1)*40,40,40);
            this.add(tablero1[i][j]);
            tablero1[i][j].setBackground(new java.awt.Color(246, 246, 246));
            tablero1[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }






    }



}