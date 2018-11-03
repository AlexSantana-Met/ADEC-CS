/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.interfaz;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro
 */
public class Error extends JFrame {

    private JLabel close1, eti1, fondo, titulo, img, barra;

    public Error(String error) {
        initComponents();
        this.setSize(400, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.fondo.setIcon(new ImageIcon("images/fondo.png"));
        this.close1.setIcon(new ImageIcon("images/close3.png"));
        this.img.setIcon(new ImageIcon("images/inbox_close2.png"));
        this.barra.setIcon(new ImageIcon("images/barra.png"));
        this.eti1.setText(error);
    }

    public void initComponents() {
        close1 = new javax.swing.JLabel();
        eti1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 540));
        getContentPane().setLayout(null);

        close1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        close1.setForeground(new java.awt.Color(255, 255, 255));
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        getContentPane().add(close1);
        close1.setBounds(370, 5, 30, 30);
        
        titulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Error");
        getContentPane().add(titulo);
        titulo.setBounds(40, 5, 80, 35);
        
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(img);
        img.setBounds(30, 85, 50, 50);
        
        eti1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eti1.setForeground(new java.awt.Color(255, 255, 255));
        eti1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        eti1.setText("Ha ocurrido un error en el proceso");
        getContentPane().add(eti1);
        eti1.setBounds(90, 50, 300, 130); 
       
        getContentPane().add(barra);
        barra.setBounds(0, 0, 400, 40);
        
        fondo.setOpaque(true);
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 400, 200);

    }

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {
        close1.setIcon(new ImageIcon("images/close2.png"));
        close1.setForeground(new Color(0, 255, 102));
    }

    private void closeMouseExited(java.awt.event.MouseEvent evt) {
        close1.setIcon(new ImageIcon("images/close3.png"));
        close1.setForeground(new Color(255, 255, 255));
    }

//    public static void main(String[] args) {
//        new Error("Ingrese el nombre con que se generará el archivo").setVisible(true);
//    }

}
