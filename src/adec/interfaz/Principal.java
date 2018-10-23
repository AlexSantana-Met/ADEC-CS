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
public class Principal extends javax.swing.JFrame {

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
        this.open.setIcon(new ImageIcon("images/file_plus.png"));
        this.close.setIcon(new ImageIcon("images/close.png"));
        this.nameFile.setText("Archivo Seleccionado: Ningun archivo seleccionado");
        this.txtcodigo.setEditable(false);
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
//        while (ban2) {
            if (selecionado.showDialog(this, "Abrir Archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = selecionado.getSelectedFile();
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
                        System.out.println(ruta);
                    } else {
                        ban = true;
                        JOptionPane.showMessageDialog(null, "Por favor, seleccione un archivo de texto (.txt)",
                                "Atención", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
//        }
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

        close = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(400, 540));
        getContentPane().setLayout(null);

        close.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
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
        });
        getContentPane().add(open);
        open.setBounds(10, 10, 110, 30);

        txtcodigo.setColumns(20);
        txtcodigo.setRows(5);
        jScrollPane1.setViewportView(txtcodigo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 380, 380);

        nameFile.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        nameFile.setForeground(new java.awt.Color(255, 255, 255));
        nameFile.setText("Archivo Seleccionado: Ningun archivo seleccionado");
        getContentPane().add(nameFile);
        nameFile.setBounds(10, 450, 260, 30);

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
        });
        getContentPane().add(btnAdec);
        btnAdec.setBounds(300, 470, 80, 30);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\EdwinAlejandro\\Desktop\\ADEC-CS\\images\\fondo.png")); // NOI18N
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
    }//GEN-LAST:event_btnAdecMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameFile;
    private javax.swing.JLabel open;
    private javax.swing.JTextArea txtcodigo;
    // End of variables declaration//GEN-END:variables
}
