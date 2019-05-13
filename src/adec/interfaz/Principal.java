/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.interfaz;

import adec.control.ADEC;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.layout.Border;
import javafx.stage.FileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.Archivos;

/**
 *
 * @author EdwinAlejandro
 */
public class Principal extends javax.swing.JFrame {

    PopUp p;
    Error e;
    Correcto c;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setSize(400, 540);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("ADEC-CS");
        this.jLabel1.setIcon(new ImageIcon("images/fondo.png"));
        this.jLabel4.setIcon(new ImageIcon("images/barra.png"));
        this.open.setIcon(new ImageIcon("images/file_plus3.png"));
        this.close.setIcon(new ImageIcon("images/close3.png"));
        this.info.setIcon(new ImageIcon("images/information3.png"));
        this.btnAdec.setIcon(new ImageIcon("images/lock_close3.png"));
        this.nameFile.setText("Archivo Seleccionado: Ningun archivo seleccionado");
        this.txtcodigo.setEditable(false);
        this.btnAdec.setText("<html><body>Convertir<br/>ADEC-CS</body></html>");
        this.btnAdec.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
    }
    FileChooser select;
    JFileChooser seleccionado = new JFileChooser();
    File archivo = null;
    Archivos gestion = new Archivos();
    int cantidad_filas = 1;
    String FilasArchivo[];
    String contenido = "";
    boolean ban = false;
    ADEC bc;
    String ruta;

    public void AbrirArchivo() {
        boolean ban2 = true;
//        select = new FileChooser();
//        select.setTitle("Seleccionar archivo de texto");
//        select.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));
//        try {
//            File arch = select.showOpenDialog(null);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//            System.out.println("Error: " + e.getLocalizedMessage());
//            System.out.println("Error: " + e);
//        }
        if (seleccionado.showDialog(this, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith(".txt")) {
                    String nombreArchivo = archivo.getName();
                    contenido = gestion.AbrirTexto(archivo);
                    txtcodigo.setText(contenido);
                    ban = true;
                    this.nameFile.setText("Archivo Seleccionado: " + archivo.getName());
                    this.name.setText(nombreArchivo.substring(0, nombreArchivo.length() - 4));
                    ban2 = false;
                    ruta = archivo.getAbsolutePath();
//                    System.out.println(ruta);
                } else {
                    ban = true;
                    String error = "<html><body>Por favor, seleccione un archivo <br/>de texto (.txt).</body></html>";
                    openError(error);
                }
            }
        }
    }

    public void GuardarArchivoADEC(String texto, String nombre) {
        if (this.getTitle().equals("Nuevo Archivo")) {
            String error = "<html><body>Por favor, el archivo debe ser <br/>guardado primero como txt.</body></html>";
            openError(error);
        } else {
            archivo = new File(getRuta() + nombre);
            contenido = texto;
            String respuesta = gestion.GuardarTexto(archivo, contenido);
            if (respuesta != null) {
                String x = archivo.getAbsolutePath(), res = "";
                for (int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) == '\\') {
                        res = res.concat(String.valueOf("/"));
                    } else {
                        res = res.concat(String.valueOf(x.charAt(i)));
                    }
                }
                String partes[] = res.split("/");
                x = "";
                for (int i = 0; i < partes.length - 1; i++) {
                    if (i < partes.length - 1) {
                        x = x.concat(partes[i] + "\\");
                    }
                }
                String msj = "<html><body>" + respuesta + "<br/>" + archivo.getName()
                        + "<br/><br/> En la ruta:<br/>" + x + "</body></html>";

                openCorrect(msj);
            } else {
                String error = "<html><body>Ha ocurrido un error.</body></html>";
                openError(error);
            }
        }
    }

    public String getRuta() {
        String res = "";
        for (int i = 0; i < ruta.length(); i++) {
            if (ruta.charAt(i) == '\\') {
                res = res.concat(String.valueOf("/"));
            } else {
                res = res.concat(String.valueOf(ruta.charAt(i)));
            }
        }
        String partes[] = res.split("/");
        res = "";
        for (String parte : partes) {
            if (!parte.endsWith(".txt")) {
                res = res.concat(parte + "\\");
            }
        }
        return res;
    }

    private void openError(String error) {
        if (e == null) {
            e = new Error(error);
            e.setVisible(true);
        } else {
            e.dispose();
            e = new Error(error);
            e.setVisible(true);
        }
    }

    private void openCorrect(String msj) {
        if (c == null) {
            c = new Correcto(msj);
            c.setVisible(true);
        } else {
            c.dispose();
            c = new Correcto(msj);
            c.setVisible(true);
        }
    }

    private void openPopUp() {
        if (p == null) {
            p = new PopUp();
            p.setVisible(true);
        } else {
            p.dispose();
            p = new PopUp();
            p.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcodigo = new javax.swing.JTextArea();
        nameFile = new javax.swing.JLabel();
        eti = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        btnAdec = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        close.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
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
        getContentPane().add(close);
        close.setBounds(370, 10, 30, 30);

        open.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        open.setForeground(new java.awt.Color(255, 255, 255));
        open.setText("Abrir Archivo");
        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                openMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openMouseExited(evt);
            }
        });
        getContentPane().add(open);
        open.setBounds(10, 10, 110, 30);

        info.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setText("Acerca de");
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoMouseExited(evt);
            }
        });
        getContentPane().add(info);
        info.setBounds(130, 10, 120, 30);

        txtcodigo.setColumns(20);
        txtcodigo.setRows(5);
        jScrollPane1.setViewportView(txtcodigo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 380, 380);

        nameFile.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        nameFile.setForeground(new java.awt.Color(255, 255, 255));
        nameFile.setText("Archivo Seleccionado: Ningun archivo seleccionado");
        getContentPane().add(nameFile);
        nameFile.setBounds(10, 450, 380, 30);

        eti.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        eti.setForeground(new java.awt.Color(255, 255, 255));
        eti.setText("Nombre del archivo encriptado: ");
        getContentPane().add(eti);
        eti.setBounds(10, 480, 180, 14);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(10, 500, 250, 30);

        btnAdec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdec.setForeground(new java.awt.Color(255, 255, 255));
        btnAdec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdec.setText("ADEC-CS");
        btnAdec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdecMouseExited(evt);
            }
        });
        getContentPane().add(btnAdec);
        btnAdec.setBounds(290, 490, 100, 40);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 50);

        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseClicked
        AbrirArchivo();
    }//GEN-LAST:event_openMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void btnAdecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdecMouseClicked
        if (ban) {
            if (!name.getText().isEmpty()) {
                if (!txtcodigo.getText().isEmpty()) {
                    String nombre = name.getText().concat(".adec");
                    Long ti = System.currentTimeMillis(), tf;
                    String convertido = ADEC.algoritmoADEC(txtcodigo.getText());
                    GuardarArchivoADEC(convertido, nombre);
                    tf = System.currentTimeMillis();
                    System.out.println("Tiempo: " + (tf - ti));
                } else {
                    String error = "<html><body>El archivo no contiene texto.</body></html>";
                    openError(error);
                }
            } else {
                String error = "<html><body>Ingrese el nombre con que se generará </br>el nuevo archivo.</body></html>";
                openError(error);
            }
        } else {
            String error = "<html><body>Seleccione un archivo para poder <br/>generar un nuevo archivo.</body></html>";
            openError(error);
        }
    }//GEN-LAST:event_btnAdecMouseClicked

    private void openMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseEntered
        open.setIcon(new ImageIcon("images/file_plus2.png"));
        open.setForeground(new Color(0, 255, 102));
    }//GEN-LAST:event_openMouseEntered

    private void openMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseExited
        open.setIcon(new ImageIcon("images/file_plus3.png"));
        open.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_openMouseExited

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        close.setIcon(new ImageIcon("images/close2.png"));
        close.setForeground(new Color(0, 255, 102));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        close.setIcon(new ImageIcon("images/close3.png"));
        close.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_closeMouseExited

    private void btnAdecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdecMouseEntered
        Font font = btnAdec.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnAdec.setFont(font.deriveFont(attributes));
        this.btnAdec.setIcon(new ImageIcon("images/lock_close2.png"));
        btnAdec.setForeground(new Color(0, 255, 102));
        btnAdec.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 102), 1, true));
    }//GEN-LAST:event_btnAdecMouseEntered

    private void btnAdecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdecMouseExited
        Font font = btnAdec.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, -1);
        btnAdec.setFont(font.deriveFont(attributes));
        this.btnAdec.setIcon(new ImageIcon("images/lock_close3.png"));
        btnAdec.setForeground(new Color(255, 255, 255));
        btnAdec.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1, true));
    }//GEN-LAST:event_btnAdecMouseExited

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        if (p == null) {
            p = new PopUp();
            p.setVisible(true);
        } else {
            p.dispose();
            p = new PopUp();
            p.setVisible(true);
        }
    }//GEN-LAST:event_infoMouseClicked

    private void infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseEntered
        info.setIcon(new ImageIcon("images/information2.png"));
        info.setForeground(new Color(0, 255, 102));
    }//GEN-LAST:event_infoMouseEntered

    private void infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseExited
        info.setIcon(new ImageIcon("images/information3.png"));
        info.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_infoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdec;
    private javax.swing.JLabel close;
    private javax.swing.JLabel eti;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameFile;
    private javax.swing.JLabel open;
    private javax.swing.JTextArea txtcodigo;
    // End of variables declaration//GEN-END:variables
}
