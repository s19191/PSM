import java.io.*;

public class TworzenieMacierzy
{
    public static void main(String[] args) {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("macierz.txt");
            for (int i = 1; i < 41 ; i++) {
                for (int j = 1; j < 41 ; j++) {
                    int sum = 0;
                    if (i == 1) {
                        sum += -150;
                    }
                    if (i == 40) {
                        sum += -200;
                    }
                    if (j == 1) {
                        sum += -100;
                    }
                    if (j == 40) {
                        sum += -50;
                    }
                    String tmp = "";
                    for (int k = 1; k < 41; k++) {
                        for (int l = 1; l < 41; l++) {
                            if (i == k && j == l) {
                                tmp += -4 + "\t";
                            } else if (i -1 == k && j == l) {
                                tmp += 1 + "\t";
                            } else if (i +1 == k && j == l) {
                                tmp += 1 + "\t";
                            } else if (i == k && j == l -1) {
                                tmp += 1 + "\t";
                            } else if (i == k && j == l +1) {
                                tmp += 1 + "\t";
                            } else {
                                tmp += 0 + "\t";
                            }
                        }
                    }
                tmp += sum;
                zapis.println(tmp);
            }
        }
            zapis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}