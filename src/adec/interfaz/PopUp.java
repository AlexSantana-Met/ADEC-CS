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
public class PopUp extends JFrame {

    private JLabel close1, eti1, jLabel11, barra, titulo;

    public PopUp() {
        initComponents();
        this.setSize(300, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.jLabel11.setIcon(new ImageIcon("images/fondo.png"));
        this.close1.setIcon(new ImageIcon("images/close3.png"));
        this.barra.setIcon(new ImageIcon("images/barra.png"));
    }

    public void initComponents() {
        close1 = new javax.swing.JLabel();
        eti1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

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
        close1.setBounds(270, 5, 30, 35);

        eti1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        eti1.setForeground(new java.awt.Color(255, 255, 255));
        eti1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eti1.setText("<html><body><div align=\"center\">Algoritmo de Encriptación y Compresión<br/><br/>Colin Santana<br/><br/>Taller de Investigación II<br/><br/><b>ADEC-CS</b></div></body></html>");
        getContentPane().add(eti1);
        eti1.setBounds(20, 50, 260, 130);
        
        titulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Información");
        getContentPane().add(titulo);
        titulo.setBounds(40, 5, 90, 35);

        getContentPane().add(barra);
        barra.setBounds(0, 0, 400, 40);

        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 300, 200);
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
//        new PopUp().setVisible(true);
//    }
}
