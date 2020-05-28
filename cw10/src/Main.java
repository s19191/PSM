import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.showGui();
        } catch(Exception exc) {
            JOptionPane.showMessageDialog(null, "Creation failed, " + exc);
        }
    }

    public void showGui() {
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("Gra w życie");
            jf.setPreferredSize(new Dimension(900,600));
            jf.setLayout(new BorderLayout());
            int size;
            String sizeString = JOptionPane.showInputDialog("Podaj wiekość planszy");
            try {
                size = Integer.parseInt(sizeString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Podano nie prawidłową wielkość, ustawiono na 20 " + e);
                size = 20;
            }
            Board board = new Board(size);
            JPanel jPBoard = board.getBoard();
            jf.add(jPBoard, BorderLayout.CENTER);
            JPanel buttons = new JPanel(new GridLayout(0,1));
            JButton nextStep = new JButton("Kliknij, jeżeli chcesz wykonać iteracje programu");
            nextStep.addActionListener(e -> {
                board.nextIteration();
            });
            buttons.add(nextStep);
            JButton newFormula = new JButton("Kliknij, jeżeli chcesz wprowadzić nowe zasady");
            newFormula.addActionListener(e -> {
                String newRule = JOptionPane.showInputDialog("Podaj nową regułe, pamiętaj o formacie [cyfra][cyfra].../[cyfra][cyfra]...");
                if (newRule != null && newRule != "" && newRule.contains("/") && newRule.split("/").length == 2) {
                    String[] tmp = newRule.split("/");
                    try {
                        Integer.parseInt(tmp[0].trim());
                        Integer.parseInt(tmp[1].trim());
                        board.setNewRule(tmp[0].trim(), tmp[1].trim());
                    } catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, pamiętaj o formacie [cyfra][cyfra].../[cyfra][cyfra]...!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, pamiętaj o formacie [cyfra][cyfra].../[cyfra][cyfra]...!");
                }
            });
            buttons.add(newFormula);
            JButton clear = new JButton("Kliknij, jeżeli chcesz wyczyścić plansze");
            clear.addActionListener(e -> {
                board.clear();
            });
            buttons.add(clear);
            // tu jest próba nr2 zaimplementowania zmiany kolorów
//            JButton changeAliveColor = new JButton("Kliknij, jeżeli chcesz zmienić kolor żywych komórek");
//            changeAliveColor.addActionListener(e -> {
//                Color newColor = JColorChooser.showDialog(null, "Wybierz kolor żywych", Board.aliveColor);
//                Board.aliveColor = newColor;
//            });
//            buttons.add(changeAliveColor);
//            JButton changeDeadColor = new JButton("Kliknij, jeżeli chcesz zmienić kolor martwych komórek");
//            changeAliveColor.addActionListener(e -> {
//                Color newColor = JColorChooser.showDialog(null, "Wybierz kolor martwych", Board.deadColor);
//                Board.deadColor = newColor;
//            });
//            buttons.add(changeDeadColor);
            jf.add(buttons,BorderLayout.EAST);
            // tu jest próba nr1 zaimplementowania zmiany kolorów
//            JPanel colors = new JPanel(new GridLayout(0,1));
//            JTextArea aliveColorJTA = new JTextArea("Wybrany kolor na komórki żywe");
//            aliveColorJTA.setEditable(false);
//            colors.add(aliveColorJTA);
//            colo aliveColorChanger = new JColorChooser();
//            aliveColorChanger.setColor(Color.RED);
//            aliveColorChanger.addCo
//            colors.add(aliveColorChanger);
//            JTextArea deadColorJTA = new JTextArea("Wybrany kolor na komórki martwe");
//            aliveColorJTA.setEditable(false);
//            colors.add(deadColorJTA);
//            JColorChooser deadColorChanger = new JColorChooser();
//            deadColorChanger.setColor(Color.BLACK);
//            colors.add(deadColorChanger);
//            jf.add(colors, BorderLayout.EAST);
            jf.pack();
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setVisible(true);
        });
    }
}
