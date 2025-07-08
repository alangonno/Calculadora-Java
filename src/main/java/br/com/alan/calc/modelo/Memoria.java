package br.com.alan.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando  {ZERAR, NUMERO, VIRG, DIV, MULT, SUB, SOMA, IGUAL}

    private static final Memoria instancia = new Memoria();

    private TipoComando ultimaOperacao;
    private boolean substituir;
    private String textoAtual = "";
    private String textoBuffer = "";

    private final List<MemoriaObservador> observadores = new ArrayList<>();


    private Memoria() {

    }

    public static Memoria getInstance() {
        return instancia;
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void addObserverador(MemoriaObservador observador){
        observadores.add(observador);

    }

    public void processaroComando(String texto) {

        TipoComando tipoComando = detectarTipoComando(texto);

        if (tipoComando == TipoComando.ZERAR) {
            textoAtual = "";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        } else if (tipoComando == TipoComando.NUMERO) {
            textoAtual = substituir ? texto : textoAtual + texto;
            substituir = false;
        } else if (tipoComando == TipoComando.VIRG && !textoAtual.contains(",")) {
            textoAtual = substituir ? texto : textoAtual + texto;
            if (textoAtual.equals(",")) textoAtual = "0,";
            substituir = false;
        } else {
            substituir = true;
            textoAtual = obterResultadoOperacao();
            textoBuffer = textoAtual;
            ultimaOperacao = tipoComando;
        }

        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
    }

    private String obterResultadoOperacao() {
        if(ultimaOperacao == null) return textoAtual;

        double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));

        double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));

        double resultado = 0;

        switch (ultimaOperacao) {
            case SOMA -> resultado = numeroBuffer + numeroAtual;
            case SUB -> resultado = numeroBuffer - numeroAtual;
            case MULT -> resultado = numeroBuffer * numeroAtual;
            case DIV -> resultado = numeroBuffer / numeroAtual;
        }

        if (ultimaOperacao == TipoComando.IGUAL) {
            return textoAtual;
        }

        String resultadoString = Double.toString(resultado).replace(".", ",");
        boolean inteiro = resultadoString.endsWith(",0");
        return inteiro ? resultadoString.replace(",0", "") : resultadoString;

    }

    private TipoComando detectarTipoComando(String texto) {

        if(textoAtual.isEmpty()&& texto == "0") {
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {
            return switch (texto) {
                case "AC" -> TipoComando.ZERAR;
                case "+" -> TipoComando.SOMA;
                case "/" -> TipoComando.DIV;
                case "-" -> TipoComando.SUB;
                case "*" -> TipoComando.MULT;
                case "=" -> TipoComando.IGUAL;
                case "," -> TipoComando.VIRG;

                default -> null;
            };
        }

    }

}
