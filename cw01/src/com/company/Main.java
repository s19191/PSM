package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rodzajKata = 2;
        String tmpKat = "";
        double kat = 0;
        int dokladnosc = 0;
        double wynik = 0.00;
        boolean czyDaSieZrobic = true;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj rodzaj kąta, wpisz 0 jeżeli kąt podawany jest w radianach, natomiast jeżeli kąt jest podawany w stopniach to wpisz 1");
            rodzajKata = scanner.nextInt();
            System.out.println("Podaj kąt");
            tmpKat = scanner.next();
            try {
                if (rodzajKata==0) {
                    try {
                        kat = Double.parseDouble(tmpKat);
                    } catch (NumberFormatException e) {
                        if (tmpKat.charAt(tmpKat.length()-1)=='π'){
                            if (tmpKat.split("π")[0].contains("/")){
                                Double tmp2 = Double.parseDouble(tmpKat.split("π")[0].split("/")[0]) / Double.parseDouble(tmpKat.split("π")[0].split("/")[1]);
                                kat = (tmp2%2) * Math.PI;
                            } else {
                                kat = Double.parseDouble(tmpKat.split("π")[0]) * Math.PI;
                                kat = kat%6.28318530718;
                            }
                        }
                    }
                } else {
                    if (rodzajKata==1) {
                        kat = Double.parseDouble(tmpKat);
                        kat = kat%360;
                        kat = Math.toRadians(kat);
                    } else {
                        czyDaSieZrobic = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Nie da się przejść z stopni na radiay");
            }
            System.out.println("Podaj dokładność");
            dokladnosc = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono nie zgodne dane");
        }
        if (czyDaSieZrobic) {
            if (kat >= Math.PI / 2 && kat < Math.PI) {
                kat = Math.PI - kat;
            } else
            if (kat >= Math.PI && kat < 3/2 * Math.PI) {
                kat = -(kat - Math.PI);
            } else
            if (kat >= 3/2 * Math.PI && kat < 2 * Math.PI) {
                kat = -(2 * Math.PI - kat);
            }
            boolean czyDodawac = true;
            for (int i = 1; i < dokladnosc*2 + 1; i+=2) {
                if (czyDodawac) {
                    wynik += Math.pow(kat,i)/silnia(i);
                    czyDodawac = false;
                } else {
                    wynik -= Math.pow(kat,i)/silnia(i);
                    czyDodawac = true;
                }
                System.out.print("Wartość z naszej metody: ");
                System.out.println(String.format("%.15f", wynik));
                System.out.print("Różnica pomiędzy naszą metodą oraz wbudowaną metodą liczącą sin: ");
                System.out.println(String.format("%.15f",Math.abs(wynik-Math.sin(kat))));
            }
        } else {
            System.out.println("Nie da się zrobić!");
        }
    }
    public static double silnia(int i){
        if (i <= 1){
            return 1;
        } else {
            return i * silnia(i - 1);
        }
    }
}
