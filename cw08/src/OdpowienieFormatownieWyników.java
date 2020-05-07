import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class OdpowienieFormatownieWyników {

    public static void main(String[] args) {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("res.txt");
            List<String> lines = new ArrayList<>();
            try {
                lines = Files.readAllLines(new File("odwr.txt").toPath(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String tmp = "";
            for (int i = 1599; i >= 0; i--) {
                tmp = lines.get(i) + "\t" + tmp;
                if (i%40 == 0) {
                    zapis.print(tmp);
                    tmp = "";
                    zapis.print("\n");
                }
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}