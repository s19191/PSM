import java.util.ArrayList;
import java.util.List;

public class Stos {
    List<String> stos;

    public Stos() {
        stos = new ArrayList<>();
    }

    public void push(String s) {
        stos.add(s);
    }

    public String pop() {
        String result = stos.get(stos.size() -1);
        stos.remove(result);
        return result;
    }
}
