/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.interfaz;

import adec.control.ADEC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.Archivos;

/**
 *
 * @author EdwinAlejandro
 */
public class VtnPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VtnPrincipal
     */
    public VtnPrincipal() {
        initComponents();
        this.setSize(530, 732);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("ADEC-CS");
//        ADEC.fillAscii();
//        ADEC.fillCode();
//        ADEC.fillC();
        this.menAbrir.setIcon(new ImageIcon("images/directory_plus.png"));
        this.menSalir.setIcon(new ImageIcon("images/close.png"));
    }

    JFileChooser selecionado = new JFileChooser();
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
        while (ban2) {
            if (selecionado.showDialog(this, "Abrir Archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = selecionado.getSelectedFile();
                if (archivo.canRead()) {
                    if (archivo.getName().endsWith(".txt")) {
                        String nombreArchivo = archivo.getName();
                        contenido = gestion.AbrirTexto(archivo);
                        txtcodigo.setText(contenido);
                        ban = true;
                        this.jLabel1.setText("Archivo Seleccionado: " + archivo.getName());
                        this.name.setText(nombreArchivo.substring(0, nombreArchivo.length() - 4));
                        ban2 = false;
                        ruta = archivo.getAbsolutePath();
                        System.out.println(ruta);
                    } else {
                        ban = true;
                        JOptionPane.showMessageDialog(null, "Por favor, seleccione un archivo de texto (.txt)",
                                "Atención", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }

    public void GuardarArchivo() {
        contenido = txtcodigo.getText();
        String respuesta = gestion.GuardarTexto(archivo, contenido);
        if (respuesta == null) {
            if (GuardarComoTexto()) {
                FilasDelArchivo();
            } else {
                JOptionPane.showMessageDialog(null, "Es necesario guardar el arhivo para ser verificado",
                        "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el archivo",
                    "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            FilasDelArchivo();
        }
    }

    public boolean GuardarComoTexto() {
        if (selecionado.showDialog(this, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = selecionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                contenido = txtcodigo.getText();
                String respuesta = gestion.GuardarTexto(archivo, contenido);
                if (respuesta != null) {
                    JOptionPane.showMessageDialog(null, respuesta + archivo.getName());
                    this.setTitle(archivo.getName());
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error",
                            "Error", JOptionPane.ERROR);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo debe ser guardado como formato txt",
                        "Atención", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            return false;
        }
    }

    public void NuevoArchivo() {
        String nombre = JOptionPane.showInputDialog(null,
                "Ingresa el nombre para el archivo de texto: ", "Nuevo archivo") + ".txt";
        while (nombre.isEmpty() || !nombre.endsWith(".txt")) {
            nombre = JOptionPane.showInputDialog(null,
                    "Ingresa el nombre para el archivo de texto:", "Nuevo archivo") + ".txt";
        }
        if (!nombre.isEmpty()) {
            archivo = new File("../../" + nombre);
            contenido = txtcodigo.getText();
            String respuesta = gestion.GuardarTexto(archivo, contenido);
            if (respuesta != null) {
                JOptionPane.showMessageDialog(null, respuesta + archivo.getName());
                this.setTitle(archivo.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo debe ser guardado como formato txt",
                    "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void GuardarArchivoADEC(String texto, String nombre) {
        if (this.getTitle().equals("Nuevo Archivo")) {
            JOptionPane.showMessageDialog(null, "El archivo debe ser guardado primero como txt",
                    "Atención", JOptionPane.INFORMATION_MESSAGE);
        } else {
            archivo = new File(getRuta() + nombre);
            contenido = texto;
            String respuesta = gestion.GuardarTexto(archivo, contenido);
            if (respuesta != null) {
                JOptionPane.showMessageDialog(null,
                        respuesta + archivo.getName() + " en la ruta:\n\n " + archivo.getAbsolutePath(), "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
//                this.setTitle(archivo.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR);
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

    public void FilasDelArchivo() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            cantidad_filas = 1;
            while (br.readLine() != null) {
                cantidad_filas++;
            }
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int i = 0;
            FilasArchivo = new String[cantidad_filas];
            System.out.println("Nuevas filas");
            while ((FilasArchivo[i] = br.readLine()) != null) {
                System.out.println(FilasArchivo[i]);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void limpia() {
        txtcodigo.setText("");
        ban = false;
        archivo = null;
        this.setTitle("Nuevo Archivo");
//        tablaEstados.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcodigo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menAbrir = new javax.swing.JMenuItem();
        menSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setUndecorated(true);
        getContentPane().setLayout(null);

        txtcodigo.setEditable(false);
        txtcodigo.setColumns(20);
        txtcodigo.setRows(5);
        jScrollPane1.setViewportView(txtcodigo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(15, 16, 500, 540);

        jButton1.setText("ADEC-CS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 650, 99, 29);

        jLabel1.setText("Archivo Seleccionado: Ningun archivo seleccionado");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 570, 380, 40);

        jLabel2.setText("Nombre del archivo encriptado:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 620, 230, 20);
        getContentPane().add(name);
        name.setBounds(20, 650, 360, 40);

        jMenu3.setText("Archivo");

        menAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        menAbrir.setText("Abrir Archivo");
        menAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAbrirActionPerformed(evt);
            }
        });
        jMenu3.add(menAbrir);

        menSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        menSalir.setText("Salir");
        menSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSalirActionPerformed(evt);
            }
        });
        jMenu3.add(menSalir);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem4.setText("Acerca de");
        jMenu4.add(jMenuItem4);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menSalirActionPerformed

    private void menAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAbrirActionPerformed
        AbrirArchivo();
        //        jButton1.setEnabled(true);
    }//GEN-LAST:event_menAbrirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ban) {
            if (!name.getText().isEmpty()) {
                String nombre = name.getText().concat(".as");
                String convertido = ADEC.algoritmoADEC(txtcodigo.getText());
//                String convertido = ADEC.concat0s1s(ADEC.stringToBinary8Bits(txtcodigo.getText()));
//                convertido = ADEC.finalOutput(convertido);
                GuardarArchivoADEC(convertido, nombre);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre con que se generará el nuevo archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnPrincipal().setVisible(true);
            }
        });
    }

    //Codigo de guardar
//    if (txtcodigo.getText().equals(contenido)) {
//            AbrirArchivo();
//        } else {
//            int res;
//            res = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?");
//            if (res == 0) {
//                if (archivo == null) {
//                    NuevoArchivo();
//                } else {
//                    GuardarArchivo();
//                }
//            } else if (res == 1) {
//                AbrirArchivo();
//            }
//        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menAbrir;
    private javax.swing.JMenuItem menSalir;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea txtcodigo;
    // End of variables declaration//GEN-END:variables
}
