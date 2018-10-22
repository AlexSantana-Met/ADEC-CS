/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author EdwinAlejandro
 */
public class Archivos {

    FileInputStream entrada;
    FileOutputStream salida;

    public Archivos() {

    }

    public String AbrirTexto(File archivo) {
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                contenido += caracter;
            }
        } catch (Exception e) {
        }
        return contenido;
    }
    
    public String GuardarTexto(File archivo, String contenido) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bystesTxt = contenido.getBytes();
            respuesta = "Se ha guardado el archivo ";
            salida.write(bystesTxt);
        } catch (Exception e) {
            respuesta = "Error en el guardado de archivo";
        }
        return respuesta;
    }
}
