import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public final static double da = 25.00;

    public static void main(String[] args) {
        double x = 0.0;
        double y = 0.0;
        double alpha = 25.0 * Math.PI / 180;
        String xString = x + "";
        String yString = y + "";
        String w = "X";
        String P1From = "X";
        String P1To = "F+[[X]-X]-F[-FX]+X";
        //do testowania jak inna reguła
        //String P1To = "F[-X]+X";
        String P2From = "F";
        String P2To = "FF";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj parametr n");
        int n = getterFromScanner(scanner,"n");
        for (int i = 0; i < n; i++) {
            w = w.replace(P1From,P1To);
            w = w.replace(P2From,P2To);
        }
//        w = w.replace("[X]","");
//        w = w.replace("[-X]","");
//        w = w.replace("-X","");
//        w = w.replace("+X","");
//        w = w.replace("X","");
        System.out.println(w);
        PrintWriter zapis = null;
        Stos stos = new Stos();
        try {
            zapis = new PrintWriter("res.txt");
            for (int i = 0; i < w.length(); i++) {
                switch (w.charAt(i)) {
                    case 'F': {
                        x += Math.cos(alpha);
                        y += Math.sin(alpha);
                        xString = x + "";
                        yString = y + "";
                        zapis.println(xString.replace(".",",") + "\t" + yString.replace(".",","));
                        break;
                    }
                    case '+': {
                        alpha += da * Math.PI / 180;
//                        zapis.println(xString.replace(".",",") + "\t" + yString.replace(".",","));
                        break;
                    }
                    case '-': {
                        alpha -= da * Math.PI / 180;
//                        zapis.println(xString.replace(".",",") + "\t" + yString.replace(".",","));
                        break;
                    }
                    case '[': {
                        stos.push(x + "#" + y + "#" + alpha);
//                        zapis.println(xString.replace(".",",") + "\t" + yString.replace(".",","));
                        break;
                    }
                    case ']': {
                        String pop = stos.pop();
                        String[] tmp = pop.split("#");
                        x = Double.parseDouble(tmp[0]);
                        y = Double.parseDouble(tmp[1]);
                        alpha = Double.parseDouble(tmp[2]);
                        zapis.println("\t");
                        break;
                    }
                    case 'X': {
//                        zapis.println("\t");
                        break;
                    }
                }
            }
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getterFromScanner(Scanner scanner, String whatIsSearching) {
        int parametr = -1;
        try {
            parametr = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Nie prawidłowa wartość, nie została podana liczba naturalna");
            System.out.println("Podaj ponownie paramtr "+whatIsSearching);
            parametr = getterFromScanner(scanner, whatIsSearching);
        }
        return parametr;
    }
}
