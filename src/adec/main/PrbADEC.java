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

        
        char x = 32;
        String r = "";
        int n = 0;
        
        while (n < 1024){
            if (x > 125) {
                x = 32;
            }
            r = r.concat(String.valueOf(x++));
            n++;
        }
        System.out.println(r);
//        ADEC.fillAscii();
//        ADEC.fillCode();
//        ADEC.fillC();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String cadena = "";
//        boolean ban = false;
//        do {
//            System.out.print("Ingresa una cadena: ");
//            try {
//                cadena = br.readLine();
//                ban = true;
//            } catch (IOException ex) {
//                ban = false;
//            }
//        } while (!ban);
//        String aux = ADEC.stringToBinary8Bits(cadena);
//        System.out.println("Cadena en Binario 8 bits: " + aux);
//        String aux2 = ADEC.concat0s1s(aux);
//        System.out.println("Cadena concat0s1s: " + aux2);
//        String aux3 = ADEC.finalOutput(aux2);
//        System.out.println("Cadena finalOutput: " + aux3);
//        aux2 = ADEC.stringToBinary4Bits(aux3);
//        System.out.println("Cadena en Binario 4 bits: " + aux2);
//        int i = 0;
//        String x, cad = "";
//        while (i < aux2.length()) {
//            try {
//                x = aux2.substring(i, i + 4);
//                i = i + 4;
//            } catch (Exception e) {
//                x = aux2.substring(i, aux2.length() - 1);
//                i = aux2.length();
//            }
//            cad = cad.concat(String.valueOf(ADEC.binaryToInt(x)));
//        }
//        System.out.println("CAD: " + cad);
////        System.out.println("Concat0s1s: "+ ADEC.concat0s1s(aux2));
//        aux3 = ADEC.nuevoValor(aux2);
//        System.out.println("Cadena nuevoValor: " + aux3);
//        System.out.println("Binario a int: " + ADEC.binaryToInt("1010"));
//        aux = ADEC.finalOutput(aux3);
//        System.out.println(aux);
    }

}
