import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wielomiany extends JFrame{
    private JTextField wielomianJTextField;
    private JTextField startJTextField;
    private JTextField stopJTextField;
    private JTextField samplingJTextField;
    private JButton rysujButton;
    private JPanel panel1;
    private JPanel root;

    private String errorString = null;
    private HashMap<Double, Double> punkty;
    private Double sampling;
    private LinkedList<Double> wspolczynniki;
    private Double start;
    private Double stop;
    private JPanel wykrespanel;

    public Wielomiany() {
        super("Program rysujący wykresy wielomianów");
        add(panel1);
        add(root);
        setSize(640, 480);
        setMinimumSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rysujButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    wykrespanel = new WykresPanel();
                    rysujButtonActionPerformed(evt);
                    WykresFrame wykresFrame = new WykresFrame();
                    wykresFrame.add(wykrespanel);
                    wykresFrame.setLocationRelativeTo(null);
                    wykresFrame.setVisible(true);
                }
        });
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Wielomiany wielomiany = new Wielomiany();
        wielomiany.setVisible(true);
    }
    private void rysujButtonActionPerformed(ActionEvent evt){
        errorString = null;
        Pattern pattern = Pattern.compile("[-?[0-9]*//.?[0-9]*,]*");
        Matcher matcher = pattern.matcher(wielomianJTextField.getText());
        wielomianJTextField.setInputVerifier(new MyVerifier("[-?[0-9]*//.?[0-9]*,]*"));
        startJTextField.setInputVerifier(startJTextField.getInputVerifier());
        stopJTextField.setInputVerifier(stopJTextField.getInputVerifier());
        samplingJTextField.setInputVerifier(new MyVerifier("-?[0-9]{1,}\\.?[0-9]*"));
        InputVerifier doubleVerifier = samplingJTextField.getInputVerifier();
        if (!wielomianJTextField.getInputVerifier().verify(wielomianJTextField)) {
            errorString = "Błędnie wpisane współczynniki (liczby rzeczywiste oddzielane przecinkami)!";
        } else if (!doubleVerifier.verify(startJTextField)) {
            errorString = "Błędnie wpisany początek zakresu (liczba rzeczywista)!";
        } else if (!doubleVerifier.verify(stopJTextField)) {
            errorString = "Błędnie wpisany koniec zakresu (liczba rzeczywista)!";
        } else if (!doubleVerifier.verify(samplingJTextField)) {
            errorString = "Błędnie wpisane próbkowanie (liczba rzeczywista)!";
        } else if (Double.parseDouble(startJTextField.getText()) == Double.parseDouble(stopJTextField.getText())) {
            errorString = "Błędne dane wejściowe - początek równy końcowi zakresu!";
        }
        else{
            Double temp;
            start = Double.parseDouble(startJTextField.getText());
            stop = Double.parseDouble(stopJTextField.getText());
            sampling = Double.parseDouble(samplingJTextField.getText());
            wspolczynniki = new LinkedList<>();
            for (String factor : wielomianJTextField.getText().split(",")) {
                wspolczynniki.add(Double.parseDouble(factor));
            }
            if (start > stop) {
                temp = start;
                start = stop;
                stop = temp;
            }
            punkty = new HashMap<>();
            for (Double i = start; i <= stop; i += sampling) {
                punkty.put(i, f(i));
            }
        }

    }
    private Double f(Double x) {
        Double out = 0.0;
        for (Double w : wspolczynniki) {
            out = out * x + w;
        }
        return out;
    }
    public class WykresFrame extends JFrame {

        public WykresFrame() {
            super("Wykres wprowadzonego wielomianu");
            setSize(700,700);
            setMinimumSize(new Dimension(400,400));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    private class WykresPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Integer width = this.getWidth() - 15;
            Integer height = this.getHeight() - 15;
            Long temp;
            if (errorString != null) {
                g.drawString(errorString, 10, 15);
            } else if (start != null) {
                g.drawLine(15, 0, 15, height);
                g.drawLine(15, height, width + 15, height);
                temp = Math.round(start);
                g.drawString(temp.toString(), 10, height + 15);
                temp = Math.round(stop);
                g.drawString(temp.toString(), width - 10, height + 15);
                Double scaleX = width / Math.abs(start - stop);

                Double minY = punkty.get(start);
                Double maxY = minY;
                for (Map.Entry<Double, Double> point : punkty.entrySet()) {
                    if (point.getValue() < minY) {
                        minY = point.getValue();
                    } else if (point.getValue() > maxY) {
                        maxY = point.getValue();
                    }
                }

                if (maxY != minY) {
                    temp = Math.round(maxY);
                    g.drawString(temp.toString(), 0, 15);
                    temp = Math.round(minY);
                    g.drawString(temp.toString(), 0, height);
                    Double scaleY = height / Math.abs(maxY - minY);
                    Double prevX = null, prevY = null;
                    for (Double i = start; i <= stop; i += sampling) {
                        if (prevY == null) {
                            prevY = punkty.get(i);
                            prevX = i;
                        } else {
                            g.drawLine((int) ((prevX - start) * scaleX) + 15,
                                    (int) (height - (prevY - minY) * scaleY), (int)
                                            ((i - start) * scaleX) + 15, (int)
                                            (height - (punkty.get(i) - minY) * scaleY));
                            prevY = punkty.get(i);
                            prevX = i;
                        }
                    }
                } else if (minY != 0) {
                    g.drawLine(15, (int) height/2, width + 15, (int) height/2);
                    temp = Math.round(maxY);
                    g.drawString(temp.toString(), 0, (int) height/2 + 5);
                }
            }
        }
    }
    private class MyVerifier extends InputVerifier {

        private final String validString;

        public MyVerifier(String validString) {
            this.validString = validString;
        }

        @Override
        public boolean verify(JComponent input) {
            JTextField textField;
            textField = (JTextField) input;
            return textField.getText().matches(validString);
        }
    }
}
