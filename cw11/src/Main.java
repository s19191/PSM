public class Main {

    public static void main(String[] args) {

        double x;
        double y;
        Integer n = 200;
        int no = 0;
        for (int i = 0; i < n; i++) {
            x = Math.random() * Math.PI;
            y = Math.random();
            if (Math.sin(x) > y) {
                no++;
            }
        }
        double P = Math.PI * no/n;
        System.out.println("Pole naszej całki obliczone metodą Monte Carlo wynosi: " + P);
        System.out.println("Pole naszej całki obliczone metodą analityczną wynosi: 2");
        System.out.println("Wartość bezwzględna z róznicy wartości: " + Math.abs(P - 2));
    }
}
