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
public class BinaryConverter {

    private static Map<Integer, Character> ascii = new HashMap<>();

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
        ascii.put(128, '�');
        ascii.put(129, '�');
        ascii.put(130, '�');
        ascii.put(131, '�');
        ascii.put(132, '�');
        ascii.put(133, '�');
        ascii.put(134, '�');
        ascii.put(135, '�');
        ascii.put(136, '�');
        ascii.put(137, '�');
        ascii.put(138, '�');
        ascii.put(139, '�');
        ascii.put(140, '�');
        ascii.put(141, '�');
        ascii.put(142, '�');
        ascii.put(143, '�');
        ascii.put(144, '�');
        ascii.put(145, '�');
        ascii.put(146, '�');
        ascii.put(147, '�');
        ascii.put(148, '�');
        ascii.put(149, '�');
        ascii.put(150, '�');
        ascii.put(151, '�');
        ascii.put(152, '�');
        ascii.put(153, '�');
        ascii.put(154, '�');
        ascii.put(155, '�');
        ascii.put(156, '�');
        ascii.put(157, '�');
        ascii.put(158, '�');
        ascii.put(159, '?');
        ascii.put(160, '�');
        ascii.put(161, '�');
        ascii.put(162, '�');
        ascii.put(163, '�');
        ascii.put(164, '�');
        ascii.put(165, '�');
        ascii.put(166, '�');
        ascii.put(167, '�');
        ascii.put(168, '�');
        ascii.put(169, '�');
        ascii.put(170, '�');
        ascii.put(171, '�');
        ascii.put(172, '�');
        ascii.put(173, '�');
        ascii.put(174, '�');
        ascii.put(175, '�');
        ascii.put(176, '?');
        ascii.put(177, '?');
        ascii.put(178, '?');
        ascii.put(179, '?');
        ascii.put(180, '?');
        ascii.put(181, '�');
        ascii.put(182, '�');
        ascii.put(183, '�');
        ascii.put(184, '�');
        ascii.put(185, '?');
        ascii.put(186, '?');
        ascii.put(187, '?');
        ascii.put(188, '?');
        ascii.put(189, '�');
        ascii.put(190, '�');
        ascii.put(191, '?');
        ascii.put(192, '?');
        ascii.put(193, '?');
        ascii.put(194, '?');
        ascii.put(195, '?');
        ascii.put(196, '?');
        ascii.put(197, '?');
        ascii.put(198, '�');
        ascii.put(199, '�');
        ascii.put(200, '?');
        ascii.put(201, '?');
        ascii.put(202, '?');
        ascii.put(203, '?');
        ascii.put(204, '?');
        ascii.put(205, '?');
        ascii.put(206, '?');
        ascii.put(207, '�');
        ascii.put(208, '�');
        ascii.put(209, '�');
        ascii.put(210, '�');
        ascii.put(211, '�');
        ascii.put(212, '�');
        ascii.put(213, '?');
        ascii.put(214, '�');
        ascii.put(215, '�');
        ascii.put(216, '�');
        ascii.put(217, '?');
        ascii.put(218, '?');
        ascii.put(219, '?');
        ascii.put(220, '?');
        ascii.put(221, '�');
        ascii.put(222, '�');
        ascii.put(223, '?');
        ascii.put(224, '�');
        ascii.put(225, '�');
        ascii.put(226, '�');
        ascii.put(227, '�');
        ascii.put(228, '�');
        ascii.put(229, '�');
        ascii.put(230, '�');
        ascii.put(231, '�');
        ascii.put(232, '�');
        ascii.put(233, '�');
        ascii.put(234, '�');
        ascii.put(235, '�');
        ascii.put(236, '�');
        ascii.put(237, '�');
        ascii.put(238, '�');
        ascii.put(239, '�');
        ascii.put(240, '?');
        ascii.put(241, '�');
        ascii.put(242, '?');
        ascii.put(243, '�');
        ascii.put(244, '�');
        ascii.put(245, '�');
        ascii.put(246, '�');
        ascii.put(247, '�');
        ascii.put(248, '�');
        ascii.put(249, '�');
        ascii.put(250, '�');
        ascii.put(251, '�');
        ascii.put(252, '�');
        ascii.put(253, '�');
        ascii.put(254, '?');
    }

    public static String stringToBinary(String cadena) {
        String salida = "";
        int b, d, exp, n;
        for (int i = 0; i < cadena.length(); i++) {
            n = getValue(cadena.charAt(i));
            System.out.println(n);
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
            salida = salida.concat(c + " ");
        }
        return salida;
    }

    public static String concat0s1s(String cadena) {
        String cad = "";
        boolean b1 = true, b0 = true;
        int i = 0;
        while (i < cadena.length()) {
            while (cadena.charAt(i) == 0) {
                
            }
            while (cadena.charAt(i) == 1) {
                
            }
        }
        return cad;
    }

    public static int getValue(char c) {
        int n = -1;
        for (Map.Entry<Integer, Character> entry : ascii.entrySet()) {
            if (c == entry.getValue()) {
                n = entry.getKey();
                break;
            }
        }
        return n;
    }

}
