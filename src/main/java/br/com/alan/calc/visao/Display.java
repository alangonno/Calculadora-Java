package br.com.alan.calc.visao;
import br.com.alan.calc.modelo.Memoria;
import br.com.alan.calc.modelo.MemoriaObservador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Display extends JPanel implements MemoriaObservador {

    private final JLabel label;

    public Display(){
        Memoria.getInstance().addObserverador(this);

        setBackground(new Color(46, 49, 50));
        label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.white);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        add(label);
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
