package br.com.alan.calc.visao;

import br.com.alan.calc.modelo.Memoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Teclado extends JPanel implements ActionListener {



    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;


        //linha 1
        c.gridwidth = 3;
        adicionarBotao("AC", Color.darkGray, c, 0, 0);
        c.gridwidth = 1;
        adicionarBotao("/", Color.orange, c, 3, 0);

        //Linha 2
        adicionarBotao("7", Color.gray, c, 0, 1);
        adicionarBotao("8", Color.gray, c, 1, 1);
        adicionarBotao("9", Color.gray, c, 2, 1);
        adicionarBotao("*", Color.orange, c, 3, 1);

        //Linha 3
        adicionarBotao("4", Color.gray, c, 0, 2);
        adicionarBotao("5", Color.gray, c, 1, 2);
        adicionarBotao("6", Color.gray, c, 2, 2);
        adicionarBotao("-", Color.orange, c, 3, 2);

        //Linha 4
        adicionarBotao("1", Color.gray, c, 0, 3);
        adicionarBotao("2", Color.gray, c, 1, 3);
        adicionarBotao("3", Color.gray, c, 2, 3);
        adicionarBotao("+", Color.orange, c, 3, 3);

        //Linha 5
        c.gridwidth = 2;
        adicionarBotao("0", Color.gray, c, 0, 4);
        c.gridwidth = 1;
        adicionarBotao(",", Color.gray, c, 2, 4);
        adicionarBotao("=", Color.orange, c, 3, 4);

    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {

        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            Memoria.getInstance().processaroComando(botao.getText());
        }


    }
}
