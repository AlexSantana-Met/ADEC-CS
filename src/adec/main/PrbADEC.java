/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.main;

import adec.control.BinaryConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro
 */
public class PrbADEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryConverter.fillAscii();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        boolean ban = false;
        do {
            System.out.print("Ingresa una cadena: ");
            try {
                cadena = br.readLine();
                ban = true;
            } catch (IOException ex) {
                ban = false;
            }
        } while (!ban);
        String aux = BinaryConverter.stringToBinary(cadena);
        System.out.println("Cadena en Binario: " + aux);

    }

}
