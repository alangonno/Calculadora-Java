package br.com.alan.calc.visao;
import javax.swing.JFrame;
import java.awt.*;

public class Calculadora extends JFrame{

    public Calculadora() {
        organizerLayout();
        
        setSize(232, 322);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void organizerLayout() {

        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);

        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
