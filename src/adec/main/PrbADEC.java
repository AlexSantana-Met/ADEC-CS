/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.main;

import adec.control.ADEC;
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
        ADEC.fillAscii();
        ADEC.fillCode();
        ADEC.fillC();
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
        String aux = ADEC.stringToBinary8Bits(cadena);
        System.out.println("Cadena en Binario: " + aux);
        String aux2 = ADEC.concat0s1s(aux);
        System.out.println(aux2);
        String aux3 = ADEC.finalOutput(aux2);
        System.out.println(aux3);
        aux2 = ADEC.stringToBinary4Bits(aux3);
        System.out.println("Cadena en Binario: " + aux2);
        aux3 = ADEC.nuevoValor(aux2);
        System.out.println(aux3);
//        aux = ADEC.finalOutput(aux3);
//        System.out.println(aux);

    }

}
