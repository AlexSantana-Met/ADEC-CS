/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adec.control;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alejandro
 */
public class ADEC {

    private static Map<Integer, Character> ascii = new HashMap<>();
    private static Map<Integer, Character> code = new HashMap<>();
    private static Map<Integer, Character> c = new HashMap<>();

    public static void fillAscii() {
        ascii.put(9, '\t');
        ascii.put(10, '\n');
        ascii.put(13, '\r');
        ascii.put(32, ' ');
        ascii.put(33, '!');
        ascii.put(34, '"');
        ascii.put(35, '#');
        ascii.put(36, '$');
        ascii.put(37, '%');
        ascii.put(38, '&');
        ascii.put(39, '\'');
        ascii.put(40, '(');
        ascii.put(41, ')');
        ascii.put(42, '*');
        ascii.put(43, '+');
        ascii.put(44, ',');
        ascii.put(45, '-');
        ascii.put(46, '.');
        ascii.put(47, '/');
        ascii.put(48, '0');
        ascii.put(49, '1');
        ascii.put(50, '2');
        ascii.put(51, '3');
        ascii.put(52, '4');
        ascii.put(53, '5');
        ascii.put(54, '6');
        ascii.put(55, '7');
        ascii.put(56, '8');
        ascii.put(57, '9');
        ascii.put(58, ':');
        ascii.put(59, ';');
        ascii.put(60, '<');
        ascii.put(61, '=');
        ascii.put(62, '>');
        ascii.put(63, '?');
        ascii.put(64, '@');
        ascii.put(65, 'A');
        ascii.put(66, 'B');
        ascii.put(67, 'C');
        ascii.put(68, 'D');
        ascii.put(69, 'E');
        ascii.put(70, 'F');
        ascii.put(71, 'G');
        ascii.put(72, 'H');
        ascii.put(73, 'I');
        ascii.put(74, 'J');
        ascii.put(75, 'K');
        ascii.put(76, 'L');
        ascii.put(77, 'M');
        ascii.put(78, 'N');
        ascii.put(79, 'O');
        ascii.put(80, 'P');
        ascii.put(81, 'Q');
        ascii.put(82, 'R');
        ascii.put(83, 'S');
        ascii.put(84, 'T');
        ascii.put(85, 'U');
        ascii.put(86, 'V');
        ascii.put(87, 'W');
        ascii.put(88, 'X');
        ascii.put(89, 'Y');
        ascii.put(90, 'Z');
        ascii.put(91, '[');
        ascii.put(92, '\\');
        ascii.put(93, ']');
        ascii.put(94, '^');
        ascii.put(95, '_');
        ascii.put(96, '`');
        ascii.put(97, 'a');
        ascii.put(98, 'b');
        ascii.put(99, 'c');
        ascii.put(100, 'd');
        ascii.put(101, 'e');
        ascii.put(102, 'f');
        ascii.put(103, 'g');
        ascii.put(104, 'h');
        ascii.put(105, 'i');
        ascii.put(106, 'j');
        ascii.put(107, 'k');
        ascii.put(108, 'l');
        ascii.put(109, 'm');
        ascii.put(110, 'n');
        ascii.put(111, 'o');
        ascii.put(112, 'p');
        ascii.put(113, 'q');
        ascii.put(114, 'r');
        ascii.put(115, 's');
        ascii.put(116, 't');
        ascii.put(117, 'u');
        ascii.put(118, 'v');
        ascii.put(119, 'w');
        ascii.put(120, 'x');
        ascii.put(121, 'y');
        ascii.put(122, 'z');
        ascii.put(123, '{');
        ascii.put(124, '|');
        ascii.put(125, '}');
        ascii.put(126, '~');
        ascii.put(128, 'Ç');
        ascii.put(129, 'ü');
        ascii.put(130, 'é');
        ascii.put(131, 'â');
        ascii.put(132, 'ä');
        ascii.put(133, 'à');
        ascii.put(134, 'å');
        ascii.put(135, 'ç');
        ascii.put(136, 'ê');
        ascii.put(137, 'ë');
        ascii.put(138, 'è');
        ascii.put(139, 'ï');
        ascii.put(140, 'î');
        ascii.put(141, 'ì');
        ascii.put(142, 'Ä');
        ascii.put(143, 'Å');
        ascii.put(144, 'É');
        ascii.put(145, 'æ');
        ascii.put(146, 'Æ');
        ascii.put(147, 'ô');
        ascii.put(148, 'ö');
        ascii.put(149, 'ò');
        ascii.put(150, 'û');
        ascii.put(151, 'ù');
        ascii.put(152, 'ÿ');
        ascii.put(153, 'Ö');
        ascii.put(154, 'Ü');
        ascii.put(155, 'ø');
        ascii.put(156, '£');
        ascii.put(157, 'Ø');
        ascii.put(158, '×');
        ascii.put(159, '?');
        ascii.put(160, 'á');
        ascii.put(161, 'í');
        ascii.put(162, 'ó');
        ascii.put(163, 'ú');
        ascii.put(164, 'ñ');
        ascii.put(165, 'Ñ');
        ascii.put(166, 'ª');
        ascii.put(167, 'º');
        ascii.put(168, '¿');
        ascii.put(169, '®');
        ascii.put(170, '¬');
        ascii.put(171, '½');
        ascii.put(172, '¼');
        ascii.put(173, '¡');
        ascii.put(174, '«');
        ascii.put(175, '»');
        ascii.put(176, '?');
        ascii.put(177, '?');
        ascii.put(178, '?');
        ascii.put(179, '?');
        ascii.put(180, '?');
        ascii.put(181, 'Á');
        ascii.put(182, 'Â');
        ascii.put(183, 'À');
        ascii.put(184, '©');
        ascii.put(185, '?');
        ascii.put(186, '?');
        ascii.put(187, '?');
        ascii.put(188, '?');
        ascii.put(189, '¢');
        ascii.put(190, '¥');
        ascii.put(191, '?');
        ascii.put(192, '?');
        ascii.put(193, '?');
        ascii.put(194, '?');
        ascii.put(195, '?');
        ascii.put(196, '?');
        ascii.put(197, '?');
        ascii.put(198, 'ã');
        ascii.put(199, 'Ã');
        ascii.put(200, '?');
        ascii.put(201, '?');
        ascii.put(202, '?');
        ascii.put(203, '?');
        ascii.put(204, '?');
        ascii.put(205, '?');
        ascii.put(206, '?');
        ascii.put(207, '¤');
        ascii.put(208, 'ğ');
        ascii.put(209, 'Ğ');
        ascii.put(210, 'Ê');
        ascii.put(211, 'Ë');
        ascii.put(212, 'È');
        ascii.put(213, '?');
        ascii.put(214, 'Í');
        ascii.put(215, 'Î');
        ascii.put(216, 'Ï');
        ascii.put(217, '?');
        ascii.put(218, '?');
        ascii.put(219, '?');
        ascii.put(220, '?');
        ascii.put(221, '¦');
        ascii.put(222, 'Ì');
        ascii.put(223, '?');
        ascii.put(224, 'Ó');
        ascii.put(225, 'ß');
        ascii.put(226, 'Ô');
        ascii.put(227, 'Ò');
        ascii.put(228, 'õ');
        ascii.put(229, 'Õ');
        ascii.put(230, 'µ');
        ascii.put(231, 'ş');
        ascii.put(232, 'Ş');
        ascii.put(233, 'Ú');
        ascii.put(234, 'Û');
        ascii.put(235, 'Ù');
        ascii.put(236, 'ı');
        ascii.put(237, 'İ');
        ascii.put(238, '¯');
        ascii.put(239, '´');
        ascii.put(240, '?');
        ascii.put(241, '±');
        ascii.put(242, '?');
        ascii.put(243, '¾');
        ascii.put(244, '¶');
        ascii.put(245, '§');
        ascii.put(246, '÷');
        ascii.put(247, '¸');
        ascii.put(248, '°');
        ascii.put(249, '¨');
        ascii.put(250, '·');
        ascii.put(251, '¹');
        ascii.put(252, '³');
        ascii.put(253, '²');
        ascii.put(254, '?');
    }

    public static void fillCode() {
        code.put(10, 'A');
        code.put(20, 'B');
        code.put(30, 'C');
        code.put(40, 'D');
        code.put(50, 'E');
        code.put(60, 'F');
        code.put(70, 'G');
        code.put(80, 'H');
        code.put(11, 'a');
        code.put(21, 'b');
        code.put(31, 'c');
        code.put(41, 'd');
        code.put(51, 'e');
        code.put(61, 'f');
        code.put(71, 'g');
        code.put(81, 'h');
    }

    public static void fillC() {
        c.put(0, 'A');
        c.put(1, 'B');
        c.put(2, 'C');
        c.put(3, 'D');
        c.put(4, 'E');
        c.put(5, 'F');
        c.put(6, 'G');
        c.put(7, 'H');
        c.put(8, 'a');
        c.put(9, 'b');
        c.put(10, 'c');
        c.put(11, 'd');
        c.put(12, 'e');
        c.put(13, 'f');
        c.put(14, 'g');
        c.put(15, 'h');
    }

    public static String stringToBinary(String cadena, int nB) {
        String salida = "";
        int b, d, exp, n;
        System.out.println("Total de caracteres: " + cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            n = getValueASCII(cadena.charAt(i));
            exp = b = d = 0;
            while (n != 0) {
                d = n % 2;
                b = b + d * (int) Math.pow(10, exp);
                exp++;
                n = n / 2;
            }
            String c = String.valueOf(b);
            while (c.length() < nB) {
                String x = c;
                c = "0" + x;
            }
            salida = salida.concat(c);
        }
        System.out.println(salida.length());
        return salida;
    }
    
    public static String stringToBinary8Bits(String cadena) {
        String salida = "";
        int b, d, exp, n;
        System.out.println("Total de caracteres: " + cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            n = getValueASCII(cadena.charAt(i));
            exp = b = d = 0;
            while (n != 0) {
                d = n % 2;
                b = b + d * (int) Math.pow(10, exp);
                exp++;
                n = n / 2;
            }
            String c = String.valueOf(b);
            while (c.length() < 8) {
                String x = c;
                c = "0" + x;
            }
            salida = salida.concat(c);
        }
        System.out.println(salida.length());
        return salida;
    }

    public static String stringToBinary4Bits(String cadena) {
        String salida = "";
        int b, d, exp, n;
        System.out.println("Total de caracteres: " + cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            n = getValueC(cadena.charAt(i));
            exp = b = d = 0;
            while (n != 0) {
                d = n % 2;
                b = b + d * (int) Math.pow(10, exp);
                exp++;
                n = n / 2;
            }
            String c = String.valueOf(b);
            while (c.length() < 4) {
                String x = c;
                c = "0" + x;
            }
            salida = salida.concat(c);
        }
        System.out.println(salida.length());
        return salida;
    }

    public static String concat0s1s(String cadena) {
        String cad = "";
        boolean b1 = false, b0 = false;
        int i = 0, cont0 = 0, cont1 = 0, contF = 0;
        while (i < cadena.length()) {
            while (i < cadena.length() && cadena.charAt(i) == '0' && cont0 < 8) {
                b0 = true;
                cont0++;
                b1 = !b0;
                i++;
            }
            if (b0) {
                cad = cad.concat(String.valueOf(cont0) + "0");
                cont0 = 0;
                b0 = false;
            }
            while (i < cadena.length() && cadena.charAt(i) == '1' && cont1 < 8) {
                b1 = true;
                cont1++;
                b0 = !b1;
                i++;
            }
            if (b1) {
                cad = cad.concat(String.valueOf(cont1) + "1");
                cont1 = 0;
                b1 = false;
            }
        }
        return cad;
    }

    public static String nuevoValor(String cadena) {
        int i = 0;
        String salida = "";
        while (i < cadena.length()) {
            if (cadena.substring(i, i + 2).equals("00")) {
                salida = salida.concat(String.valueOf('0'));
            } else if (cadena.substring(i, i + 2).equals("01")) {
                salida = salida.concat(String.valueOf('1'));
            } else if (cadena.substring(i, i + 2).equals("10")) {
                salida = salida.concat(String.valueOf('2'));
            } else if (cadena.substring(i, i + 2).equals("11")) {
                salida = salida.concat(String.valueOf('3'));
            }
            i = i + 2;
        }
        return salida;
    }

    public static String finalOutput(String codigo) {
        int i = 0, x = -1;
        String cadena = "";
        while (i < codigo.length()) {
            x = Integer.parseInt(codigo.substring(i, i + 2));
            cadena = cadena.concat(String.valueOf(code.get(x)));
            i = i + 2;
        }
        return cadena;
    }

    public static int getValueASCII(char c) {
        int n = -1;
        for (Map.Entry<Integer, Character> entry : ascii.entrySet()) {
            if (c == entry.getValue()) {
                n = entry.getKey();
                break;
            }
        }
        return n;
    }

    public static int getValueC(char x) {
        int n = -1;
        for (Map.Entry<Integer, Character> entry : c.entrySet()) {
            if (x == entry.getValue()) {
                n = entry.getKey();
                break;
            }
        }
        return n;
    }
    
    public static String algoritmoADEC(String cadena){
        fillAscii();
        fillC();
        fillCode();
//        nuevoValor(stringToBinary4Bits(finalOutput(concat0s1s(stringToBinary8Bits(cadena)))));
        String aux = stringToBinary8Bits(cadena);
        String aux2 = concat0s1s(aux);
        String aux3 = finalOutput(aux2);
        aux2 = stringToBinary4Bits(aux3);
        aux3 = nuevoValor(aux2);
        return aux3;
    }

}
